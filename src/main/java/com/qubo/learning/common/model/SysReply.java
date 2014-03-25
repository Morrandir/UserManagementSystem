package com.qubo.learning.common.model;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Created by Qubo_Song on 3/25/14.
 */
public class SysReply {
    private int reply_id;
    private SysPost post;
    private String reply_content;
    private SysUser user;
    private Timestamp post_time;

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public SysPost getPost() {
        return post;
    }

    public void setPost(SysPost post) {
        this.post = post;
    }

    @Size(min = 1, max = 250, message = "Reply content must be 1~250 characters.")
    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public Timestamp getPost_time() {
        return post_time;
    }

    public void setPost_time(Timestamp post_time) {
        this.post_time = post_time;
    }
}
