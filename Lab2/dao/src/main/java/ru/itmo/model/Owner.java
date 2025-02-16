package ru.itmo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Represents an owner entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name")
    private String login;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleName role;

}
