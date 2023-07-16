package com.ritesh.InstagramBackend.service;

import com.ritesh.InstagramBackend.model.Post;
import com.ritesh.InstagramBackend.model.User;
import com.ritesh.InstagramBackend.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;
    public String addAPost(Post post) {
        post.setPostCreatedTimeStamp(LocalDateTime.now());
        postRepo.save(post);
        return "New post added..............";
    }

    public String deleteAPost(Long postId, User user) {
        Post post = postRepo.findById(postId).orElse(null);
        if(post!=null && post.getPostOwner().equals(user)){
            postRepo.deleteById(postId);

            return "A post deleted..........";
        } else if (post == null) {
            return "Post does not exists.......... ";
        }
        else {
            return "un-authorized not allowed....";
        }

    }

    public Boolean validatePost(Post instaPost) {
        return instaPost != null && postRepo.existsById(instaPost.getPostId());
    }

    public Post getPostById(Long postId) {
        return postRepo.findById(postId).orElse(null);
    }
}
