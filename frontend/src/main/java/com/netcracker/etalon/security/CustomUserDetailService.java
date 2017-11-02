package com.netcracker.etalon.security;

import com.netcracker.pmbackend.impl.entities.UsersEntity;
import com.netcracker.pmbackend.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;


public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsersService usersService;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UsersEntity usersEntity = usersService.findByLogin(login);
        if(usersEntity == null){
            throw new UsernameNotFoundException("Login "+login+"doesn't exist!");
        }

        String username = usersEntity.getLogin();
        String password = usersEntity.getPassword();

        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                 return usersEntity.getRole();
                //return null;
            }
        };

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
        grantedAuthoritySet.add(grantedAuthority);

        UserDetails details = new User(username,password,true,true,true,true,grantedAuthoritySet);
        return details;

    }
}
