package ru.itmo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class CatDto {
    public CatDto() {

    }

    public CatDto(Integer id, String name, Date birthdate, String breed, CatColor color, Integer ownerID, List<String> friendsIDs) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.breed = breed;
        this.color = color;
        this.ownerID = ownerID;
        this.friendsIDs = friendsIDs;
    }

    private Integer id;
    private String name;
    private Date birthdate;
    private String breed;
    private CatColor color;
    private Integer ownerID;
    private List<String> friendsIDs;
}
