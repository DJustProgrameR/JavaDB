package ru.itmo.service;

import jakarta.transaction.Transactional;
import ru.itmo.model.CatColor;
import ru.itmo.model.CatDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Service interface for operations related to cats.
 */
@Service
public interface CatService {


    int saveCat(CatDto catDto);

    void deleteCat(int id);

    void changeCatName(int id, String name);

    void changeCatBirthdate(int id, Date birthdate);

    void changeCatColor(int id, CatColor color);

    void changeCatBreed(int id, String breed);

    void createFriendship(int cat1Id, int cat2Id);

    void deleteCatFriendship(int cat1Id, int cat2Id);

    CatDto getCatDto(int id);
    List<CatDto> getCatDtoByName(String name);
    List<CatDto> getCatDtoByColor(CatColor color);
}
