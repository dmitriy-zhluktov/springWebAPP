package com.arc.controller.admin;

import com.arc.controller.BaseController;
import com.arc.model.dao.User;
import com.arc.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String adminIndex() {
        return getAdminView("adminIndex");
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String adminChat() {
        return getAdminView("chat");
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String adminUsers() {
        List<User> users = userService.getAllUsers(true);

        return getAdminView("users");
    }
}
