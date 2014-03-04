package com.qubo.learning.rest.util;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.util.List;

/**
 * Created by Qubo_Song on 3/4/14.
 */
public class CustomHttpSessionEventPublisher extends HttpSessionEventPublisher {

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());


        SecurityContext scontext = SecurityContextHolder.getContext();

        SecurityContext securityContexts = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");

        //Getbean(Dao);
        //Dao.dosth();

        super.sessionDestroyed(event);
    }
}
