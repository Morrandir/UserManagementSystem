package com.qubo.learning.rest.controller;

import com.qubo.learning.common.model.SysUser;
import com.qubo.learning.common.service.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Morrandir on 14-2-27.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    /**
     * access user_overall.jsp, display all the user status.
     */
    @RequestMapping(value = "/overall", method = RequestMethod.GET)
    public String viewAll(Model model) {

        List<SysUser> sysUsers = userDao.getAllUsers();

        model.addAttribute("sysUsers", sysUsers);

        return "user_overall";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String loadUserAddForm(Model model) {

        return "user_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postUserAddForm(String userName, String password, String userRole) {

        userDao.addUser(userName, password, userRole);
        return "user_add_result";
    }

}
