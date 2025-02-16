package ru.itmo.dao;


import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itmo.model.Cat;

import java.util.List;

@Repository
public interface CatDao extends JpaRepository<Cat, Integer> {
    @NonNull
    @Query("SELECT cat FROM Cat cat WHERE cat.owner.id = :ownerId")
    List<Cat> findByOwnerId(Integer id);
}