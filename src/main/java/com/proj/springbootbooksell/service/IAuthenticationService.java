package com.proj.springbootbooksell.service;

import com.proj.springbootbooksell.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
