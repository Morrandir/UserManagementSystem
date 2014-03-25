package com.qubo.learning.common.service;

import com.qubo.learning.common.model.SysPost;
import com.qubo.learning.common.model.SysReply;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Qubo_Song on 3/17/14.
 */
public interface PostDao {

    public int getTotalPostsCount();

    public List<SysPost> getAllPosts();

    public SysPost getPostById(int postId);

    public void newPost(String postTitle, String postContent, int userId, Timestamp postTime);

    public List<SysReply> getAllRepliesByPostId(int postId);

    public void newReply(int postId, String replyContent, int userId, Timestamp postTime);

}
