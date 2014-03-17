package com.qubo.learning.common.model;

import java.sql.Timestamp;

/**
 * Created by Qubo_Song on 3/17/14.
 */
public class SysPost {
    private int post_id;
    private String post_title;
    private String post_content;
    private int user_id;
    private Timestamp post_time;
    private Timestamp last_modified_time;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Timestamp getPost_time() {
        return post_time;
    }

    public void setPost_time(Timestamp post_time) {
        this.post_time = post_time;
    }

    public Timestamp getLast_modified_time() {
        return last_modified_time;
    }

    public void setLast_modified_time(Timestamp last_modified_time) {
        this.last_modified_time = last_modified_time;
    }
}