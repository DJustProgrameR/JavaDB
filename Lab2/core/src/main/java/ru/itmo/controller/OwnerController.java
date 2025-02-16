package ru.itmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itmo.model.OwnerDto;
import ru.itmo.service.OwnerService;

import java.util.Date;
@RestController
@RequestMapping("/owner")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> createOwner(@RequestBody OwnerDto ownerDto) {
        try {
            ownerService.saveOwner(ownerDto);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findString/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<String> ownerToString(@PathVariable("id") Integer id) {
        String ans;
        try {
            OwnerDto ownerDto = ownerService.getOwnerDto(id);
            StringBuilder ownerInfo = new StringBuilder();
            ownerInfo.append("Id: ").append(ownerDto.getId()).append(' ');
            ownerInfo.append("Name: ").append(ownerDto.getLogin()).append(' ');
            ownerInfo.append("Birthdate: ").append(ownerDto.getBirthdate()).append(' ');
            ownerInfo.append("Cats ids: ");
            for (String catID : ownerDto.getCatIDs()) {
                ownerInfo.append(catID).append(' ');
            }
            ans = ownerInfo.toString();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/findDto/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<OwnerDto> getOwnerData(@PathVariable("id") Integer id) {
        OwnerDto ans;
        try {
            ans = ownerService.getOwnerDto(id);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ans);
    }

    @PutMapping("/updateName/{id}/{name}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> changeOwnerName(@PathVariable("id") Integer id,@PathVariable("name") String name) {
        try {
            ownerService.changeOwnerName(id, name);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateBirthdate/{id}/{birthdate}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> changeOwnerBirthdate(@PathVariable("id") Integer id,@PathVariable("birthdate") Date birthdate) {
        try {
            ownerService.changeOwnerBirthdate(id, birthdate);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> deleteOwner(@PathVariable("id") Integer id) {
        try {
            ownerService.deleteOwner(id);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
