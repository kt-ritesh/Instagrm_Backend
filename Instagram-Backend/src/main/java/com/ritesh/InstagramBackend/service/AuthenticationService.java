package com.ritesh.InstagramBackend.service;

import com.ritesh.InstagramBackend.model.AuthenticationToken;
import com.ritesh.InstagramBackend.model.User;
import com.ritesh.InstagramBackend.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authenticationRepo;


    public boolean authenticate(String userName, String token) {

        AuthenticationToken authToken = authenticationRepo.findFirstByTokenValue(token);
        if(authToken == null){
            return false;
        }
        String tokenUserName = authToken.getUser().getUserName();

        return tokenUserName.equals(userName);
    }


    public void saveAuthToken(AuthenticationToken authToken) {

        authenticationRepo.save(authToken);
    }

    public AuthenticationToken findFirstByUser(User user) {
        return authenticationRepo.findFirstByUser(user);
    }

    public void removeToken(AuthenticationToken authToken) {
        authenticationRepo.delete(authToken);
    }
}

