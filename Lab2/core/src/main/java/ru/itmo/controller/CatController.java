package ru.itmo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itmo.model.CatColor;
import ru.itmo.model.CatDto;
import ru.itmo.security.CurUserInfoService;
import ru.itmo.service.CatService;
import ru.itmo.service.OwnerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {
    private final CatService catService;
    private final CurUserInfoService curUserInfoService;
    public CatController(CatService catService, CurUserInfoService curUserInfoService){
        this.curUserInfoService = curUserInfoService;
        this.catService = catService;
    }
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> createCat(@RequestBody CatDto catDto) {
        try {
            catService.saveCat(catDto);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findString/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<String> catToString(@PathVariable("id") Integer id) {
        String ans;
        try {
            CatDto catDto = catService.getCatDto(id);
            if(!curUserInfoService.curUserIsAdmin() && !curUserInfoService.curUserIsOwner(catDto.getOwnerID())){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            StringBuilder catInfo = new StringBuilder();
            catInfo.append("Id: ").append(catDto.getId()).append(' ');
            catInfo.append("Name: ").append(catDto.getName()).append(' ');
            catInfo.append("Birthdate: ").append(catDto.getBirthdate()).append(' ');
            catInfo.append("Breed: ").append(catDto.getBreed()).append(' ');
            catInfo.append("Color: ").append(catDto.getColor()).append(' ');
            catInfo.append("OwnerID: ").append(catDto.getOwnerID()).append(' ');
            catInfo.append("Cat friends ids: ");
            for (String friendID : catDto.getFriendsIDs()) {
                catInfo.append(friendID).append(' ');
            }
            ans = catInfo.toString();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/findDto/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<CatDto> getCatData(@PathVariable("id") Integer id) {
        CatDto ans;
        try {
            ans = catService.getCatDto(id);
            if(!curUserInfoService.curUserIsAdmin() && !curUserInfoService.curUserIsOwner(ans.getOwnerID())){
                return ResponseEntity.ok(null);
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/findByName/{name}")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<List<CatDto>> findCatByName(@PathVariable("name") String name){
        List<CatDto> ans = new ArrayList<CatDto>();

        try {
            for(CatDto catDto :catService.getCatDtoByName(name)){
                if(curUserInfoService.curUserIsAdmin() || curUserInfoService.curUserIsOwner(catDto.getOwnerID())){
                    ans.add(catDto);
                }
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ans);
    }


    @GetMapping("/findByColor/{color}")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<List<CatDto>> findCatByColor(@PathVariable("color") CatColor color){
        List<CatDto> ans = new ArrayList<CatDto>();
        try {
            for(CatDto catDto :catService.getCatDtoByColor(color)){
                if(curUserInfoService.curUserIsAdmin() || curUserInfoService.curUserIsOwner(catDto.getOwnerID())){
                    ans.add(catDto);
                }
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ans);
    }

    @PutMapping("/updateName/{id}/{name}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> changeCatName(@PathVariable("id") Integer id,@PathVariable("name") String name) {
        try {
            catService.changeCatName(id, name);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateBirthdate/{id}/{birthdate}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> changeCatBirthdate(@PathVariable("id") Integer id,@PathVariable("birthdate") Date birthdate) {
        try {
            catService.changeCatBirthdate(id, birthdate);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateColor/{id}/{color}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> changeCatColor(@PathVariable("id") Integer id,@PathVariable("color") CatColor color) {
        try {
            catService.changeCatColor(id, color);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateBreed/{id}/{breed}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> changeCatBreed(@PathVariable("id") Integer id,@PathVariable("breed")  String breed) {
        try {
            catService.changeCatBreed(id, breed);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> deleteCat(@PathVariable("id") Integer id) {
        try {
            catService.deleteCat(id);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateFriendship/{cat1ID}/{cat2ID}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> createCatFriendship(@PathVariable("cat1ID") Integer cat1ID, @PathVariable("cat2ID") Integer cat2ID) {
        try {
            catService.createFriendship(cat1ID, cat2ID);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteFriendship/{cat1ID}/{cat2ID}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> deleteCatFriendship(@PathVariable("cat1ID") Integer cat1ID,@PathVariable("cat2ID") Integer cat2ID) {
        try {
            catService.deleteCatFriendship(cat1ID, cat2ID);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
