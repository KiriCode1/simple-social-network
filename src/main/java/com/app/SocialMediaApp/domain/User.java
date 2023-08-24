package com.app.SocialMediaApp.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;

    private List<User> friendList = new ArrayList<>();

    private List<Post> allPosts = new ArrayList<>();

    public User() {
    }

    public User(String fName, String lName, String email, String pwd, String role) {
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.password = pwd;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public List<User> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<User> friendList) {
		this.friendList = friendList;
	}

    public void addPost(Post post) {
        this.allPosts.add(post);
    }

    public void removePost(Post post) {
        this.allPosts.remove(post);
    }
}
