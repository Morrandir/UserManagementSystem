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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

    private static void convertPasswordError(BindingResult result) {
        for(ObjectError error: result.getGlobalErrors()) {
            String message = error.getDefaultMessage();
            if ("Your passwords don't match.".equals(message)) {
                if(!result.hasFieldErrors("password")) {
                    result.rejectValue("password", message, message);
                }
            }
        }
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
    public String postUserAddForm(@ModelAttribute @Valid AddUserForm addUserForm, BindingResult result) {

        convertPasswordError(result);

        if(result.hasErrors()) {
            return "user_add";
        }

        try {
            userDao.addUser(addUserForm.getUserName(), addUserForm.getPassword(), addUserForm.getUserRole());
        } catch(Exception e) {
            if(e.getCause().toString().contains("UNIQUE_SYS_USER_NAME table: SYS_USER")) {
                result.rejectValue("userName", "User name already taken.", "Sorry, the user name has been taken. Please try another one.");
            }
            return "user_add";
        }

        return "user_add_result";
    }

}
