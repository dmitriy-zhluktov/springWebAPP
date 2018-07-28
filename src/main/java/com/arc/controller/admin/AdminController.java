package com.arc.controller.admin;

import com.arc.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String adminIndex() {
        return getAdminView("adminIndex");
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String adminChat() {
        return getAdminView("chat");
    }
}
