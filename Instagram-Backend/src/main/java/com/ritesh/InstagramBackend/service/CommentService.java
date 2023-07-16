package com.ritesh.InstagramBackend.service;

import com.ritesh.InstagramBackend.model.Comment;
import com.ritesh.InstagramBackend.model.Post;
import com.ritesh.InstagramBackend.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;
    public String addComment(Comment comment) {
        comment.setCommentCreationTimeStamp(LocalDateTime.now());
        commentRepo.save(comment);
        return "Comment has been added!!!";
    }

    public Comment findComment(Long commentId) {
        return commentRepo.findById(commentId).orElse(null);
    }

    public void removeComment(Comment comment) {
        commentRepo.delete(comment);
    }

    public Integer findAllComments(Post validPost) {
        List<Comment> posts =  commentRepo.findByInstaPost(validPost);

        return posts.size();
    }
}
