package ru.itmo.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itmo.service.OwnerService;

@Service
public class CurUserInfoService {
    private final OwnerService ownerService;


    public CurUserInfoService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    private UserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetails) authentication.getPrincipal());
    }


    public boolean curUserIsOwner(Integer ownerID) {
        String login = getCurrentUser().getUsername();
        return ownerService.getOwnerDtoByName(login).getId()==ownerID;
    }
    public boolean curUserIsAdmin() {
        String login = getCurrentUser().getUsername();
        if(getCurrentUser().getAuthorities().contains(new SimpleGrantedAuthority("users:write")) && getCurrentUser().getAuthorities().contains(new SimpleGrantedAuthority("users:read"))){
            return true;
        }
        return false;
    }
}
