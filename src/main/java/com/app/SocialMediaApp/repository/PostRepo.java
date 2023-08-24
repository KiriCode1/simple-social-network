package com.app.SocialMediaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SocialMediaApp.domain.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
