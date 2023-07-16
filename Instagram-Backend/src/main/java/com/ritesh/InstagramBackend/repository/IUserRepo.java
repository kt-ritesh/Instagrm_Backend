package com.ritesh.InstagramBackend.repository;

import com.ritesh.InstagramBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    User findFirstByUserName(String newUserName);
}
