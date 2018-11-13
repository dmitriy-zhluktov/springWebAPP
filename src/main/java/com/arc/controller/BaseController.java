package com.arc.controller;

import org.aspectj.lang.annotation.AdviceName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
    private static final String USER_VIEW_PREFIX = "user/";
    private static final String ADMIN_VIEW_PREFIX = "admin/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    protected String getUserView(String viewName) {
        return USER_VIEW_PREFIX + viewName;
    }

    protected String getAdminView(String viewName) {
        return ADMIN_VIEW_PREFIX + viewName;
    }
}
