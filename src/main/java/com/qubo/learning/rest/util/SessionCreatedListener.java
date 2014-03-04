package com.qubo.learning.rest.util;

import com.qubo.learning.common.service.UserDao;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.session.HttpSessionCreatedEvent;

/**
 * Created by Morrandir on 14-3-3.
 */
//@Component
public class SessionCreatedListener implements ApplicationListener<HttpSessionCreatedEvent> {

//    @Autowired
    private UserDao userDao;

    @Override
    public void onApplicationEvent(HttpSessionCreatedEvent event) {

        SecurityContext securityContext = SecurityContextHolder.getContext();

        if(securityContext != null) {
            Authentication authentication = securityContext.getAuthentication();
            if(authentication != null) {
                User user = (User)authentication.getPrincipal();
                userDao.setUserOnlineByName(user.getUsername());
            }
        }
    }
}
