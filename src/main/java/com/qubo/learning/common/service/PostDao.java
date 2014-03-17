package com.qubo.learning.common.service;

import com.qubo.learning.common.model.SysPost;

import java.util.List;

/**
 * Created by Qubo_Song on 3/17/14.
 */
public interface PostDao {

    public int getTotalPostsCount();

    public List<SysPost> getAllPosts();
}
