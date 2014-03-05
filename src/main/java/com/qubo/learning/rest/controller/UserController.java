package com.qubo.learning.rest.controller;

import com.qubo.learning.common.model.ROLE;
import com.qubo.learning.common.model.SysUser;
import com.qubo.learning.common.service.UserDao;
import com.qubo.learning.rest.util.AddUserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setRequiredFields("userName", "password", "confirmPassword");
    }


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
        model.addAttribute("addUserForm", new AddUserForm());
        return "user_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postUserAddForm(@Valid AddUserForm addUserForm) {

        try {
            //userDao.addUser(userName, password, userRole);
        } catch(Exception e) {

        }

        return "user_add_result";
    }

}
