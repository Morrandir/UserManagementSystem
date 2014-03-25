package com.qubo.learning.rest.controller;

import com.qubo.learning.common.model.SysPost;
import com.qubo.learning.common.model.SysReply;
import com.qubo.learning.common.model.SysUser;
import com.qubo.learning.common.service.PostDao;
import com.qubo.learning.common.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
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

        int currentPage = (int) Math.ceil((double) postId / MAX_POSTS_PER_PAGE);

        SysPost post = postDao.getPostById(postId);

        if(post == null) {
            model.asMap().clear();
            return "redirect:../page/1";
        }

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("post", post);
        model.addAttribute("replies", postDao.getAllRepliesByPostId(postId));
        return "post";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewPostForm(Model model) {

        model.addAttribute("newPostForm", new SysPost());
        return "post_new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String postNewPostForm(@ModelAttribute("newPostForm") @Valid SysPost newPostForm, BindingResult result, Model model) {

        int postsCount;
        int totalPage;
        Timestamp timeStamp;
        User user;

        if(result.hasErrors()) {
            return "post_new";
        }

        timeStamp = new Timestamp(new Date().getTime());

        user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        postDao.newPost(newPostForm.getPost_title(), newPostForm.getPost_content(), userDao.getUserByName(user.getUsername()).getUser_id(), timeStamp);

        postsCount = postDao.getTotalPostsCount();
        totalPage = (int) Math.ceil((double) postsCount / MAX_POSTS_PER_PAGE);

        model.asMap().remove("numOnline");
        return "redirect:page/" + totalPage;
    }

    @RequestMapping(value = "/post/reply/{postId}", method = RequestMethod.GET)
    public String getReplyForm(@PathVariable int postId, Model model) {

        SysPost post = postDao.getPostById(postId);
        if(post == null) {
            model.asMap().clear();
            return "redirect:../../page/1";
        }

        SysReply newReplyForm = new SysReply();
        newReplyForm.setPost(post);
        model.addAttribute("newReplyForm", newReplyForm);
        return "post_reply";
    }

    @RequestMapping(value = "/post/reply/{postId}", method = RequestMethod.POST)
    public String postReplyForm(@ModelAttribute("newReplyForm") @Valid SysReply newReplyForm, BindingResult result, @PathVariable int postId, Model model) {

        Timestamp timeStamp;
        User user;

        if(result.hasErrors()) {
            return "post_reply";
        }

        timeStamp = new Timestamp(new Date().getTime());
        user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        postDao.newReply(postId, newReplyForm.getReply_content(), userDao.getUserByName(user.getUsername()).getUser_id(), timeStamp);

        model.asMap().remove("numOnline");
        return "redirect:../" + postId;
    }
}
