package com.arc.controller;

import com.arc.model.dao.User;
import com.arc.model.dao.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
    private static final String USER_VIEW_PREFIX = "user/";
    private static final String ADMIN_VIEW_PREFIX = "admin/";

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        User user = userDao.findByUserName("admin");
        return "index";
    }

    protected String getUserView(String viewName) {
        return USER_VIEW_PREFIX + viewName;
    }

    protected String getAdminView(String viewName) {
        return ADMIN_VIEW_PREFIX + viewName;
    }
}
