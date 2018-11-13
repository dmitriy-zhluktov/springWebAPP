package com.arc.controller.admin;

import com.arc.controller.BaseController;
import com.arc.model.dao.User;
import com.arc.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String adminIndex() {
        User user = userService.findByUserName("admin");
        user.getName();
        return getAdminView("adminIndex");
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String adminChat() {
        return getAdminView("chat");
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String adminUsers(HttpServletRequest request) {
        List<User> users = userService.getAllUsers(true);
        try {
            userService.addUser("admin", "1234", true, "ROLE_ADMIN");
        } catch (DuplicateKeyException e) {
            request.getSession().setAttribute("error", e.getMessage());
        }
        return getAdminView("users");
    }
}
