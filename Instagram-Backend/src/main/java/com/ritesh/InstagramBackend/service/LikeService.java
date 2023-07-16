package com.ritesh.InstagramBackend.service;

import com.ritesh.InstagramBackend.model.Like;
import com.ritesh.InstagramBackend.model.Post;
import com.ritesh.InstagramBackend.model.User;
import com.ritesh.InstagramBackend.repository.ILikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    ILikeRepo likeRepo;
    public String addLike(Like like) {
        likeRepo.save(like);
        return "Like added!!!!";
    }

    public boolean allowedToLikePost(Post instaPost, User liker) {

        List<Like> likes = likeRepo.findByInstaPostAndLiker(instaPost, liker);

        return likes!=null && likes.isEmpty();
    }

    public Integer getAllLikes(Post validPost) {
        List<Like> likeList = likeRepo.findByInstaPost(validPost);
        return likeList.size();
    }

    public Like findLike(Long likeId) {
        return likeRepo.findById(likeId).orElse(null);
    }

    public void removeLike(Like validLike) {
        likeRepo.delete(validLike);
    }
}
