package com.ritesh.InstagramBackend.repository;

import com.ritesh.InstagramBackend.model.Follow;
import com.ritesh.InstagramBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFollowRepo extends JpaRepository<Follow, Long> {
    List<Follow> findByCurrentUserAndCurrentUserFollower(User targetUser, User followerUser);

    List<Follow> findByCurrentUser(User user);
}
