package ru.itmo.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itmo.model.Owner;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser implements UserDetails {
    private String username;
    private String password;
    private List<? extends GrantedAuthority> authorities;

    public static UserDetails fromOwner(Owner owner) {
        return new User(
                owner.getLogin(),
                owner.getPassword(),
                true,
                true,
                true,
                true,
                Role.roleOf(owner.getRole()).getAuthorities()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
