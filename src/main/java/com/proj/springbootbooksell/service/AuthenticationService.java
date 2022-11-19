package com.proj.springbootbooksell.service;

import com.proj.springbootbooksell.model.User;
import com.proj.springbootbooksell.security.UserPrincipal;
import com.proj.springbootbooksell.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{

       @Autowired
       private AuthenticationManager authenticationManager;

       @Autowired
       private IJwtProvider jwtProvider;


       @Override
       public User signInAndReturnJWT(User signInRequest){

              Authentication authentication = authenticationManager.authenticate(
                      new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword()));

              UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

              String jwt = jwtProvider.generateToken(userPrincipal);


              User userSignIn = userPrincipal.getUser();

              userSignIn.setToken(jwt);

              return userSignIn;


       }

}
