package com.qubo.learning.rest.controller;

import com.qubo.learning.common.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Morrandir on 14-3-1.
 */
@Controller
public class AccessController {

    @Autowired
    private UserDao userDao;

    @ModelAttribute("numOnline")
    int getOnlineUserCount() {
        return userDao.getOnlineUserCount();
    }

    @RequestMapping(value = "/noaccess", method = RequestMethod.GET)
    public String AccessDenied () {
        return "403";
    }

}
