package com.app.SocialMediaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SocialMediaApp.domain.Commentary;

@Repository
public interface CommentaryRepo extends JpaRepository<Commentary, Long> {
}
