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
public class ViewController {
    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private UserDao userDao;

    /**
     * default access of login.jsp, display the welcome message.
     */
    @RequestMapping(value = {"/view", "/view/all"}, method = RequestMethod.GET)
    public String viewAll(Model model) {

        List<SysUser> sysUsers = userDao.getAllUsers();
        List<String> sysUserNames = new ArrayList<String>();

        for(int i = 0; i < sysUsers.size(); i++) {
            sysUserNames.add(sysUsers.get(i).getUser_name());
        }

        model.addAttribute("sysUserNames", sysUserNames);
        return "viewall";
    }
}
