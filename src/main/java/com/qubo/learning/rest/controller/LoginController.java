package com.qubo.learning.rest.controller;

import com.qubo.learning.common.service.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {

        String welcomeMessage = "Welcome! Please login to access the User Management System.";

        model.addAttribute("message", welcomeMessage);
        return "login";
    }

    /**
     * accessing home.jsp after successful login attempts, set user status to online.
     */
    @RequestMapping(value = "/login/success", method = RequestMethod.GET )
    public String login_success() {

        userDao.setCurrentUserOnline();

        return "home";
    }

    /**
     * accessing login.jsp after failed login attempts, display the error message.
     */
    @RequestMapping(value = "/login/error", method = RequestMethod.GET )
    public String login_error(Model model) {

        String errorMessage = "Login failed! Please login to access the User Management System.";

        model.addAttribute("message", errorMessage);
        return "login";
    }


    /**
     * accessing login.jsp after logout, display the logout message.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET )
    public String logout(Model model) {

        String logoutMessage = "You've been logged out! Please login to access the User Management System.";

        model.addAttribute("message", logoutMessage);
        return "login";
    }
}
