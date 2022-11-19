package com.proj.springbootbooksell.security;

import com.proj.springbootbooksell.model.User;
import com.proj.springbootbooksell.service.IUserService;
import com.proj.springbootbooksell.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           User user = userService.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));

           Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

           return UserPrincipal.builder()
                   .user(user)
                   .authorities(authorities)
                   .password(user.getPassword())
                   .id(user.getId())
                   .build();
    }
}
