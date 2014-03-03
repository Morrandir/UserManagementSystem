package com.qubo.learning.rest.handler;

import com.qubo.learning.common.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by Morrandir on 14-3-3.
 */
//@Component
public class SessionCreatedListener implements ApplicationListener<HttpSessionCreatedEvent> {

    //@Autowired
    private UserDao userDao;

    @Override
    public void onApplicationEvent(HttpSessionCreatedEvent event) {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        HttpSession session = event.getSession();


        if(securityContext != null) {
            Authentication authentication = securityContext.getAuthentication();
            if(authentication != null) {
                User user = (User)authentication.getPrincipal();
                userDao.setUserOnlineByName(user.getUsername());
            }
        }
    }
}
