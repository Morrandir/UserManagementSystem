package com.qubo.learning.rest.controller;

import com.qubo.learning.common.model.SysPost;
import com.qubo.learning.common.service.PostDao;
import com.qubo.learning.common.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Qubo_Song on 3/14/14.
 */
@Controller
@RequestMapping(value = "/bbs")
public class BBSController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PostDao postDao;

    @ModelAttribute("numOnline")
    int getOnlineUserCount() {
        return userDao.getOnlineUserCount();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getBBSMainPage() {
        int postsCount = postDao.getTotalPostsCount();
        List<SysPost> posts = postDao.getAllPosts();
        return "bbs";
    }


}
