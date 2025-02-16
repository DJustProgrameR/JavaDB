package ru.itmo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.dao.CatDao;
import ru.itmo.dao.OwnerDao;
import ru.itmo.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementation of the CatService interface.
 * Provides methods for managing cats.
 */
@Service
@Transactional
public class CatServiceImpl implements CatService {

    private final CatDao catDao;
    private final OwnerDao ownerDao;
    @Autowired
    public CatServiceImpl(CatDao catDao, OwnerDao ownerDao) {
        this.catDao = catDao;
        this.ownerDao = ownerDao;
    }

    private Cat findCat(int id) {
        try {
            return catDao.findById(id).get();
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int saveCat(CatDto catDto) {
        try {
            Cat cat = Cat.builder().name(catDto.getName()).birthdate(catDto.getBirthdate()).color(catDto.getColor()).breed(catDto.getBreed()).owner(ownerDao.findById(catDto.getOwnerID()).get()).build();
            return catDao.save(cat).getId();
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteCat(int id) {
        try {
            catDao.delete(findCat(id));
        }
        catch (Exception e) {
            throw e;
        }
    }

    private void updateCat(Cat cat) {
        try {
            catDao.save(cat);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void changeCatName(int id, String name) {
        try {
            Cat cat = findCat(id);
            cat.setName(name);
            updateCat(cat);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void changeCatBirthdate(int id, Date birthdate) {
        try {
            Cat cat = findCat(id);
            cat.setBirthdate(birthdate);
            updateCat(cat);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void changeCatColor(int id, CatColor color) {
        try {
            Cat cat = findCat(id);
            cat.setColor(color);
            updateCat(cat);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void changeCatBreed(int id, String breed) {
        try {
            Cat cat = findCat(id);
            cat.setBreed(breed);
            updateCat(cat);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void createFriendship(int cat1ID, int cat2ID) {
        try {
            Cat cat1 = findCat(cat1ID);
            Cat cat2 = findCat(cat2ID);

            List<Cat> friends1 = cat1.getFriends();
            friends1.add(cat2);
            cat1.setFriends(friends1);

            List<Cat> friends2 = cat2.getFriends();
            friends2.add(cat1);
            cat2.setFriends(friends2);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteCatFriendship(int cat1ID, int cat2ID) {
        try {
            Cat cat1 = findCat(cat1ID);
            Cat cat2 = findCat(cat2ID);

            List<Cat> friends = cat1.getFriends();
            friends.remove(cat2);
            cat1.setFriends(friends);

            friends = cat2.getFriends();
            friends.remove(cat1);
            cat2.setFriends(friends);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CatDto getCatDto(int id) {
        try {
            Cat cat = findCat(id);
            CatDto catDto = CatDto
                    .builder()
                    .id(cat.getId())
                    .name(cat.getName())
                    .birthdate(cat.getBirthdate())
                    .breed(cat.getBreed())
                    .color(cat.getColor())
                    .ownerID(cat.getOwner().getId()).build();
            List<String> friendsIDs = new ArrayList<>();
            for (Cat friend : cat.getFriends()) {
                friendsIDs.add(friend.getId().toString());
            }
            catDto.setFriendsIDs(friendsIDs);
            return catDto;
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Override
    public List<CatDto> getCatDtoByName(String name){
        try {
            List<CatDto> reqCats= new ArrayList<CatDto>();
            for(Cat cat : catDao.findAll()){
                if(cat.getName().equals(name)){
                    CatDto catDto = CatDto
                            .builder()
                            .id(cat.getId())
                            .name(cat.getName())
                            .birthdate(cat.getBirthdate())
                            .breed(cat.getBreed())
                            .color(cat.getColor())
                            .ownerID(cat.getOwner().getId()).build();
                    reqCats.add(catDto);
                }
            }
            return reqCats;
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Override
    public List<CatDto> getCatDtoByColor(CatColor color){
        try {
            List<CatDto> reqCats = new ArrayList<CatDto>();
            for(Cat cat : catDao.findAll()){
                if(cat.getColor().equals( color)){
                    CatDto catDto = CatDto
                            .builder()
                            .id(cat.getId())
                            .name(cat.getName())
                            .birthdate(cat.getBirthdate())
                            .breed(cat.getBreed())
                            .color(cat.getColor())
                            .ownerID(cat.getOwner().getId()).build();
                    reqCats.add(catDto);
                }
            }
            return reqCats;
        }
        catch (Exception e) {
            throw e;
        }
    }
}
