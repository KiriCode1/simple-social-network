package com.app.SocialMediaApp.service;

import com.app.SocialMediaApp.domain.Post;
import com.app.SocialMediaApp.repository.PostRepo;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class PostService {
    @Autowired
    private PostRepo postRepo;

    public PostRepo getPostRepo() {
        return this.postRepo;
    }

    public Optional<Post> getPostById(long id) {
        return postRepo.findById(id);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }
}
