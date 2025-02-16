package ru.itmo.security;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itmo.dao.OwnerDao;
import ru.itmo.model.Owner;
import ru.itmo.model.OwnerDto;
import ru.itmo.service.OwnerService;

@Service("userDetailsServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    private final OwnerDao ownerDao;

    @Autowired
    public UserDetailServiceImpl(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Owner owner = ownerDao.findOwnerByLogin(name).orElseThrow(
                () -> new UsernameNotFoundException(name));
        return SecurityUser.fromOwner(owner);
    }
}