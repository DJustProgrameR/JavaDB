package ru.itmo.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.itmo.model.RoleName;

import java.util.List;
import java.util.stream.Collectors;

public enum Role {
    USER(List.of(Permission.USERS_READ)),
    ADMIN(List.of(Permission.USERS_READ, Permission.USERS_WRITE));

    static Role roleOf(RoleName role) {
        return switch (role) {
            case USER -> Role.USER;
            case ADMIN -> Role.ADMIN;
        };
    }

    private final List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
    }
}