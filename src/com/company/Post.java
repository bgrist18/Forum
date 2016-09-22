package com.company;

/**
 * Created by brettgrist on 9/22/16.
 */
public class Post {
    int replyId;
    String author;
    String text;

    public Post(int replyId, String author, String text) {
        this.replyId = replyId;
        this.author = author;
        this.text = text;
    }
}
