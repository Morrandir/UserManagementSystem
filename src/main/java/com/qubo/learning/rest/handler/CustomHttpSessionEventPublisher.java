package com.qubo.learning.rest.handler;

import com.qubo.learning.common.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.security.Security;
import java.util.List;

/**
 * Created by Qubo_Song on 3/3/14.
 */
public class CustomHttpSessionEventPublisher extends HttpSessionEventPublisher {

    @Autowired
    private UserDao userDao;

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        SecurityContext securityContext = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
        ServletContext servletContext = session.getServletContext();


        if(securityContext != null) {
            Authentication authentication = securityContext.getAuthentication();
            if(authentication != null) {
                User user = (User)authentication.getPrincipal();
                userDao.setUserOfflineByName(user.getUsername());
            }
        }


        super.sessionDestroyed(event);
    }
}
