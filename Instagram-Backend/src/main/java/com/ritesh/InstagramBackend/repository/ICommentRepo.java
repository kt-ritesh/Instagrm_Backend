package com.ritesh.InstagramBackend.repository;

import com.ritesh.InstagramBackend.model.Comment;
import com.ritesh.InstagramBackend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findByInstaPost(Post validPost);
}
