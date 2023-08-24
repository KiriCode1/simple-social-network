package com.app.SocialMediaApp.controllers;

import java.security.Principal;
import java.util.Optional;
import java.util.List;

import com.app.SocialMediaApp.domain.Post;
import com.app.SocialMediaApp.domain.User;
import com.app.SocialMediaApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/get_users/")
    public List<User> getAllUsers() {
        return service.repo.findAll();
    }

    @GetMapping("/get_user_by_id/{id}")
    public Optional<User> getUser(@PathVariable User user) {
        return service.repo.findById(user.getId());
    }

    @PostMapping("/add_user")
    public void addUser(@RequestBody User user) {
        service.repo.save(user);
    }

    @DeleteMapping("/delete_user/{id}")
    public void deleteUser(@PathVariable long id) {
        service.repo.deleteById(id);
    }

    @PostMapping("/add_friend/{friend_id}")
    public void addFriendToFriends(long userId, @PathVariable long friendId) {
        service.addFriend(userId, friendId);
    }

    @PostMapping("/add_friend/{friend_id}")
    public void removeFriendFromFriends(long userId, @PathVariable long friendId) {
        service.removeFriend(userId, friendId);
    }

    @GetMapping("/get_friends/{id}")
    public List<User> getUserFriends(@PathVariable long id) {
        return service.getFriendList(id);
    }

    @PostMapping("/add_post/{id}")
    public void addUserPost(@PathVariable long id, @RequestBody Post post) {
        service.addPost(id, post);
    }

    @DeleteMapping("/delete_post/{userId}/{postId}")
    public void deleteUserPost(@PathVariable long userId, @PathVariable long postId) {
        service.deletePost(userId, postId);
    }
}
