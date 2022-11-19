package com.proj.springbootbooksell.service;

import com.proj.springbootbooksell.model.Role;
import com.proj.springbootbooksell.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username, Role role);
}
