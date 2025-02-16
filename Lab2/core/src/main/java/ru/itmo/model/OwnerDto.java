package ru.itmo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itmo.security.Role;


import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class OwnerDto {
    public OwnerDto() {
    }

    public OwnerDto(Integer id, String login, String password, RoleName role, Date birthdate, List<String> catIDs) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.birthdate = birthdate;
        this.catIDs = catIDs;
    }

    private Integer id;
    private String login;
    private String password;
    private RoleName role;
    private Date birthdate;
    private List<String> catIDs;


}
