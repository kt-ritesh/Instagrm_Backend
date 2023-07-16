package com.ritesh.InstagramBackend.controller;

import com.ritesh.InstagramBackend.dto.SignInInput;
import com.ritesh.InstagramBackend.dto.SignUpOutput;
import com.ritesh.InstagramBackend.model.*;
import com.ritesh.InstagramBackend.service.AuthenticationService;
import com.ritesh.InstagramBackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("user/signup")
    public SignUpOutput SignUpUser(@RequestBody User user){
        return userService.signUpUser(user);
    }

    @PostMapping("user/signin")
    public String signInUser(@RequestBody @Valid SignInInput signInInput){
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/sign-out")
    public String signOutUser(@RequestParam String userName, @RequestParam String Token){
        if (authenticationService.authenticate(userName, Token)) {
            return userService.signOutUser(userName);
        }else{
            return "Invalid username and token........";
        }
    }

    @PostMapping("post")
    public String addAPost(@RequestBody Post post, @RequestParam String userName, @RequestParam String Token){
        if (authenticationService.authenticate(userName, Token)) {
            return userService.addAPost(post, userName);
        }else{
            return "Invalid username and token........";
        }
    }

    @DeleteMapping("post/delete")
    public String deleteAPost(@RequestParam Long postId, @RequestParam String userName, @RequestParam String Token){
        if (authenticationService.authenticate(userName, Token)) {
            return userService.deleteAPost(postId, userName);
        }else{
            return "Invalid username and token........";
        }
    }

    @PostMapping("comment")
    public String addCommentOnPost(@RequestBody Comment comment, @RequestParam String commenterUserName, @RequestParam String commenterToken){
        if (authenticationService.authenticate(commenterUserName, commenterToken)) {
            return userService.addCommentOnPost(comment, commenterUserName);
        }else{
            return "Invalid username and token........";
        }
    }

    @DeleteMapping("comment/remove")
    public String removeComment(@RequestParam Long commentId, @RequestParam String userName, @RequestParam String Token){
        if (authenticationService.authenticate(userName, Token)) {
            return userService.removeComment(commentId, userName);
        }else{
            return "Invalid username and token........";
        }
    }

    @GetMapping("comment/count/{postId}")
    public String getPostCommentCount(@PathVariable Long postId, @RequestParam String userName, @RequestParam String Token){
        if (authenticationService.authenticate(userName, Token)) {
            return userService.getPostCommentCount(postId, userName);
        }else{
            return "Invalid username and token........";
        }
    }

    @PostMapping("like")
    public String addLike(@RequestBody Like like, @RequestParam String LikerUserName, @RequestParam String LikerToken){
        if (authenticationService.authenticate(LikerUserName, LikerToken)) {
            return userService.addLike(like, LikerUserName);
        }else{
            return "Invalid username and token........";
        }
    }

    @GetMapping("like/count/{postId}")
    public String getPostLikeCount(@PathVariable Long postId, @RequestParam String userName, @RequestParam String Token){
        if (authenticationService.authenticate(userName, Token)) {
            return userService.getPostLikeCount(postId, userName);
        }else{
            return "Invalid username and token........";
        }
    }

    @DeleteMapping("like/remove/{likeId}")
    public String removeLike(@PathVariable Long likeId, @RequestParam String LikerUserName, @RequestParam String LikerToken){
        if (authenticationService.authenticate(LikerUserName, LikerToken)) {
            return userService.removeLike(likeId, LikerUserName);
        }else{
            return "Invalid username and token........";
        }
    }

    @PostMapping("follow")
    public String followUser(@RequestBody Follow follow, @RequestParam String followerUserName, @RequestParam String followerToken){
        if (authenticationService.authenticate(followerUserName, followerToken)) {
            return userService.followUser(follow, followerUserName);
        }else{
            return "Invalid username and token........";
        }
    }

    @DeleteMapping("unfollow")
    public String unfollowUser(Long followId, @RequestParam String followerUserName, @RequestParam String followerToken){
        if (authenticationService.authenticate(followerUserName, followerToken)) {
            return userService.unfollowUser(followId, followerUserName);
        }else{
            return "Invalid username and token........";
        }
    }

    @GetMapping("follower/count/{userId}")
    public String getAllFollowerCount(@PathVariable Long userId, @RequestParam String UserName, @RequestParam String Token){
        if (authenticationService.authenticate(UserName, Token)) {
            return userService.getAllFollowerCount(userId);
        }else{
            return "Invalid username and token........";
        }
    }

}
