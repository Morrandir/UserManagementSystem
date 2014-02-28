package com.qubo.learning.controller;

import com.qubo.learning.common.model.SysUser;
import com.qubo.learning.common.service.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Morrandir on 14-2-27.
 */
@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
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
        List<String> sysUserNames = new ArrayList<String>();

        for(int i = 0; i < sysUsers.size(); i++) {
            sysUserNames.add(sysUsers.get(i).getUser_name());
        }

        model.addAttribute("sysUserNames", sysUserNames);
        return "user_overall";
    }
}
