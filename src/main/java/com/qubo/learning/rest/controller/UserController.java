package com.qubo.learning.rest.controller;

import com.qubo.learning.common.model.ROLE;
import com.qubo.learning.common.model.SysUser;
import com.qubo.learning.common.service.UserDao;
import com.qubo.learning.rest.util.AddUserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private AuthenticationManager authenticationManager;

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

    private void autoLogin(String userName, String password, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authResult = authenticationManager.authenticate(token);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authResult);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

        userDao.setUserOnlineByName(userName);
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

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String viewUserById(@PathVariable int userId, @RequestParam(value = "origin", required = false)String origin, Model model) {

        if(origin != null) {
            model.addAttribute("origin", origin);
        }

        model.addAttribute("sysUser", userDao.getUserById(userId));
        return "user_view";
    }

    @RequestMapping(value = {"/add", "/register"}, method = RequestMethod.GET)
    public String loadAddUserForm(Model model, HttpServletRequest request) {

        String uri = request.getServletPath();
        if("/user/add".equals(uri)) {
            model.addAttribute("origin", "add");
        } else if("/user/register".equals(uri)) {
            model.addAttribute("origin", "register");
        }
        model.addAttribute("addUserForm", new AddUserForm());
        return "user_add";
    }

    @RequestMapping(value = {"/add", "/register"}, method = RequestMethod.POST)
    public String postAddUserForm(@ModelAttribute @Valid AddUserForm addUserForm, BindingResult result, Model model, HttpServletRequest request) {

        String uri = request.getServletPath();
        String origin = "";
        if("/user/add".equals(uri)) {
            origin = "add";
        } else if("/user/register".equals(uri)) {
            origin = "register";
        }

        model.addAttribute("origin", origin);

        convertPasswordError(result);

        if(result.hasErrors()) {
            return "user_add";
        }

        try {
            if(addUserForm.getUserRole() == null) {
                addUserForm.setUserRole(ROLE.ROLE_USER);
            }
            userDao.addUser(addUserForm.getUserName(), addUserForm.getPassword(), addUserForm.getUserRole());
        } catch(Exception e) {
            if(e.getCause().toString().contains("UNIQUE_SYS_USER_NAME table: SYS_USER")) {
                result.rejectValue("userName", "User name already taken.", "Sorry, the user name has been taken. Please try another one.");
            }
            return "user_add";
        }

        if("register".equals(origin)) {
            autoLogin(addUserForm.getUserName(), addUserForm.getPassword(), request);
        }


        return "redirect:" + userDao.getUserByName(addUserForm.getUserName()).getUser_id();
    }

}
