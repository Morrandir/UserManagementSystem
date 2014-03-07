package com.qubo.learning.rest.controller;

import com.qubo.learning.common.service.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Qubo_Song on 2/26/14.
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserDao userDao;

    /**
     * default access of login.jsp, display the welcome message.
     */
    @RequestMapping(value = {"/login", "/login/error", "/logout/success"}, method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {

        String uri = request.getServletPath();
        String welcomeMessage;

        if("/login".equals(uri)) {
            welcomeMessage = "Welcome!";
        } else if("/login/error".equals(uri)) {
            welcomeMessage = "Login failed!";
        } else {
            welcomeMessage = "You've been logged out!";
        }

        model.addAttribute("message", welcomeMessage);
        return "login";
    }


}
