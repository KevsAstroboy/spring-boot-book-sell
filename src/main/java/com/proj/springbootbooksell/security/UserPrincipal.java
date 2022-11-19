package com.proj.springbootbooksell.security;

import com.proj.springbootbooksell.model.Role;
import com.proj.springbootbooksell.model.User;
import com.proj.springbootbooksell.util.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPrincipal implements UserDetails {

       private Long id;
       private String username;
       private transient String password;
       private transient User user;
       private Set<GrantedAuthority> authorities;


       public static UserPrincipal createSuperUser(){
           Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(Role.SYSTEM_MANAGER.name()));
           return UserPrincipal.builder()
                   .id(-1L)
                   .username("system-administrator")
                   .authorities(authorities)
                   .build();
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
