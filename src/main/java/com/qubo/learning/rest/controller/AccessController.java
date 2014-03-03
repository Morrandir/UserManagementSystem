package com.qubo.learning.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Morrandir on 14-3-1.
 */
@Controller
public class AccessController {

    @RequestMapping(value = "/noaccess", method = RequestMethod.GET)
    public String AccessDenied () {
        return "403";
    }

}
