package com.app.SocialMediaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SocialMediaApp.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
