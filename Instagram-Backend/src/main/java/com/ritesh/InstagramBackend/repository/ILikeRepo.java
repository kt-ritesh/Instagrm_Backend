package com.ritesh.InstagramBackend.repository;

import com.ritesh.InstagramBackend.model.Like;
import com.ritesh.InstagramBackend.model.Post;
import com.ritesh.InstagramBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILikeRepo extends JpaRepository<Like, Long> {
    List<Like> findByInstaPostAndLiker(Post instaPost, User liker);

    List<Like> findByInstaPost(Post validPost);
}

