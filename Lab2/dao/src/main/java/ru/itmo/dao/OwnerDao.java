package ru.itmo.dao;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itmo.model.Cat;
import ru.itmo.model.Owner;

import java.util.List;
import java.util.Optional;


@Repository
public interface OwnerDao extends JpaRepository<Owner, Integer> {
    Optional<Owner> findOwnerByLogin(@NonNull String login);
}