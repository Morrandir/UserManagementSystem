package com.qubo.learning.rest.controller;

import com.qubo.learning.common.model.SysPost;
import com.qubo.learning.common.service.PostDao;
import com.qubo.learning.common.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qubo_Song on 3/14/14.
 */
@Controller
@RequestMapping(value = "/bbs")
public class BBSController {

    /* the number of posts to display on each page should
     * be configurable in a per-session manner, here we just
     * set it temporarily for convenience.
     */
    final int MAX_POSTS_PER_PAGE = 10;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PostDao postDao;

    @ModelAttribute("numOnline")
    int getOnlineUserCount() {
        return userDao.getOnlineUserCount();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getBBSMainPage(Model model) {
        model.asMap().clear();
        return "redirect:bbs/page/1";
    }

    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    public String getBBSPage(@PathVariable int page, Model model) {

        int postsCount = postDao.getTotalPostsCount();
        int totalPage = (int) Math.ceil((double) postsCount / MAX_POSTS_PER_PAGE);

        if(page < 1) {
            model.asMap().clear();
            return "redirect:1";
        } else if(page > totalPage) {
            model.asMap().clear();
            return "redirect:" + totalPage;
        }

        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("posts",
                postDao.getAllPosts().subList(
                        (page - 1) * MAX_POSTS_PER_PAGE,
                        (page * MAX_POSTS_PER_PAGE > postsCount) ? postsCount : (page * MAX_POSTS_PER_PAGE)));
        return "bbs";
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    public String getPost(@PathVariable int postId, Model model) {

        SysPost post = postDao.getPostById(postId);

        if(post == null) {
            model.asMap().clear();
            return "redirect:../page/1";
        }

        model.addAttribute("post", post);
        return "post";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewPostForm(Model model) {

        model.addAttribute("newPostForm", new SysPost());
        return "post_new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String postNewPostForm(Model model) {
        return "bbs";
    }

}
