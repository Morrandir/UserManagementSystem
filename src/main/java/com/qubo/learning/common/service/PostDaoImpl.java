package com.qubo.learning.common.service;

import com.qubo.learning.common.mapper.SysPostMapper;
import com.qubo.learning.common.mapper.SysUserMapper;
import com.qubo.learning.common.model.SysPost;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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

        List<SysPost> posts;
        posts = postMapper.getAllPosts();

        return null;
    }
}
