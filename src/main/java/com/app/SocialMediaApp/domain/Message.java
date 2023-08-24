package com.app.SocialMediaApp.domain;

public class Message {
    private User user;
    private String text;

    public Message() {}

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
    }
}
