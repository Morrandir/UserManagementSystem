package com.qubo.learning.rest.handler;

import com.qubo.learning.common.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * Created by Qubo_Song on 3/3/14.
 */
@Component
public class SessionDestroyedListener implements ApplicationListener<SessionDestroyedEvent> {

    @Autowired
    private UserDao userDao;

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        //HttpSession session = event.;
        SecurityContext securityContext = SecurityContextHolder.getContext();//(SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
        //ServletContext servletContext = session.getServletContext();


        if(securityContext != null) {
            Authentication authentication = securityContext.getAuthentication();
            if(authentication != null) {
                User user = (User)authentication.getPrincipal();
                userDao.setUserOfflineByName(user.getUsername());
            }
        }

    }
}
