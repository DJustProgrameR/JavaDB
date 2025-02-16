package ru.itmo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.itmo.model.OwnerDto;

import java.util.Date;

/**
 * Service interface for operations related to owners.
 */
@Service
public interface OwnerService {


    void saveOwner(OwnerDto ownerDto);

    /**
     * Deletes the owner with the specified ID.
     * @param id the ID of the owner to delete
     */
    void deleteOwner(int id);

    /**
     * Changes the name of the owner with the specified ID.
     * @param id the ID of the owner
     * @param name the new name for the owner
     */
    void changeOwnerName(int id, String name);

    /**
     * Changes the birthdate of the owner with the specified ID.
     * @param id the ID of the owner
     * @param birthdate the new birthdate for the owner
     */
    void changeOwnerBirthdate(int id, Date birthdate);

    /**
     * Retrieves information about the owner with the specified ID.
     * @param id the ID of the owner
     * @return information about the owner
     */
    OwnerDto getOwnerDto(int id);
    OwnerDto getOwnerDtoByName(String name);
}
