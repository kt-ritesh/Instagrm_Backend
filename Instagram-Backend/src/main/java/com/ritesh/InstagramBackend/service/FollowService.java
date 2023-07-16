package com.ritesh.InstagramBackend.service;

import com.ritesh.InstagramBackend.model.Follow;
import com.ritesh.InstagramBackend.model.User;
import com.ritesh.InstagramBackend.repository.IFollowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    IFollowRepo followRepo;
    public boolean followAllowed(User targetUser, User followerUser) {
        List<Follow> followList = followRepo.findByCurrentUserAndCurrentUserFollower(targetUser, followerUser);

        return followList!=null && followList.isEmpty() && !targetUser.equals(followerUser);
    }

    public void startFollowing(Follow follow, User followerUser) {
        follow.setCurrentUserFollower(followerUser);
        followRepo.save(follow);
    }

    public Follow findFollow(Long followId) {
        return followRepo.findById(followId).orElse(null);
    }

    public void unfollow(Follow follow) {
        followRepo.delete(follow);
    }

    public String getAllFollowerCount(User user) {
        List<Follow> followList = followRepo.findByCurrentUser(user);
        return String.valueOf(followList.size());
    }
}
