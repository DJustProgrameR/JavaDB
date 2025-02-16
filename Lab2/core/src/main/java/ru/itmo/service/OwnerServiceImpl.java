package ru.itmo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.dao.CatDao;
import ru.itmo.dao.OwnerDao;
import ru.itmo.model.Cat;
import ru.itmo.model.Owner;
import ru.itmo.model.OwnerDto;

import java.util.*;


@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    private final OwnerDao ownerDao;

    private final CatDao catDao;

    /**
     * Constructs an OwnerServiceImpl with the given OwnerDao.
     *
     * @param ownerDao the data access object for owners
     */

    @Autowired
    public OwnerServiceImpl(OwnerDao ownerDao, CatDao catDao) {

        this.ownerDao = ownerDao;

        this.catDao = catDao;
    }

    private Owner findOwner(int id) {
        try {
            return ownerDao.findById(id).get();
        } catch (Exception e) {
            throw e;
        }
    }

    private void updateOwner(Owner owner) {
        try {
            ownerDao.save(owner);
        } catch (Exception e) {
            throw e;
        }
    }

    private List<Owner> findAllOwners() {
        try {
            return ownerDao.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void saveOwner(OwnerDto ownerDto) {
        try {
            Owner owner = Owner.builder().login(ownerDto.getLogin()).birthdate(ownerDto.getBirthdate()).password(ownerDto.getPassword()).role(ownerDto.getRole()).build();
            ownerDao.save(owner);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteOwner(int id) {
        try {
            ownerDao.delete(findOwner(id));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void changeOwnerName(int id, String name) {
        try {
            Owner owner = findOwner(id);
            owner.setLogin(name);
            updateOwner(owner);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void changeOwnerBirthdate(int id, Date birthdate) {
        try {
            Owner owner = findOwner(id);
            owner.setBirthdate(birthdate);
            updateOwner(owner);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public OwnerDto getOwnerDto(int id) {
        try {
            Owner owner = findOwner(id);
            List<String> catIDs = new ArrayList<>();
            for (Cat cat : catDao.findAll()) {
                if(cat.getOwner().getId()==id){
                    catIDs.add(cat.getId().toString());
                }
            }
            OwnerDto ownerDto = OwnerDto.builder()
                    .id(owner.getId())
                    .login(owner.getLogin())
                    .birthdate(owner.getBirthdate())
                    .password(owner.getPassword())
                    .role(owner.getRole())
                    .catIDs(catIDs).build();
            return ownerDto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public OwnerDto getOwnerDtoByName(String name){
        try {
            List<Owner> owners = findAllOwners();
            for(Owner owner:owners){
                if(owner.getLogin().equals(name)){
                    List<String> catIDs = new ArrayList<>();
                    for (Cat cat : catDao.findAll()) {
                        if(cat.getOwner().getId().equals(owner.getId())){
                            catIDs.add(cat.getId().toString());
                        }
                    }
                    OwnerDto ownerDto = OwnerDto.builder()
                            .id(owner.getId())
                            .login(owner.getLogin())
                            .birthdate(owner.getBirthdate())
                            .password(owner.getPassword())
                            .role(owner.getRole())
                            .catIDs(catIDs).build();
                    return ownerDto;
                }
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
}
