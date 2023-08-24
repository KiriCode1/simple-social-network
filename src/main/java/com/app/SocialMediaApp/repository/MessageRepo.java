package com.app.SocialMediaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SocialMediaApp.domain.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
}
