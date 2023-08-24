package com.app.SocialMediaApp.domain;

import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Post {
    @Id
    @GeneratedValue
    private long id;

    private User user;

    private long originalUserId;

    private String content;

    private String image;

    private Instant createdAt;

    List<String> love = new ArrayList<>();

    List<String> share = new ArrayList<>();

    List<Commentary> comment = new ArrayList<>();

    public long getId() {
        return this.id;
    }
}
