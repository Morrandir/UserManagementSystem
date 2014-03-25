package com.qubo.learning.common.service;

import com.qubo.learning.common.mapper.SysPostMapper;
import com.qubo.learning.common.mapper.SysReplyMapper;
import com.qubo.learning.common.mapper.SysUserMapper;
import com.qubo.learning.common.model.SysPost;
import com.qubo.learning.common.model.SysReply;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qubo_Song on 3/17/14.
 */
@Repository("postDao")
public class PostDaoImpl extends SqlSessionDaoSupport implements PostDao {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysPostMapper postMapper;

    @Autowired
    private SysReplyMapper replyMapper;

    @Autowired
    @Override
    public void setSqlSessionFactory(org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int getTotalPostsCount() {
        return postMapper.getTotalPostsCount();
    }

    @Override
    public List<SysPost> getAllPosts() {
        return postMapper.getAllPosts();
    }

    @Override
    public SysPost getPostById(int postId) {
        return postMapper.getPostById(postId);
    }

    @Override
    public void newPost(String postTitle, String postContent, int userId, Timestamp postTime) {
        postMapper.newPost(postTitle, postContent, userId, postTime, postTime);
    }

    @Override
    public List<SysReply> getAllRepliesByPostId(int postId) {
        return replyMapper.getAllRepliesByPostId(postId);
    }

    @Override
    public void newReply(int postId, String replyContent, int userId, Timestamp postTime) {
        replyMapper.newReply(postId, replyContent, userId, postTime);
    }
}
