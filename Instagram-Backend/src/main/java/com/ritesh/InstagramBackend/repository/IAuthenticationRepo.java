package com.ritesh.InstagramBackend.repository;

import com.ritesh.InstagramBackend.model.AuthenticationToken;
import com.ritesh.InstagramBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByTokenValue(String token);

    AuthenticationToken findFirstByUser(User user);
}
