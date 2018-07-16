package com.arc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminIndex() {
        return "admin";
    }

    @RequestMapping(value = "/admin/chat", method = RequestMethod.GET)
    public String adminChat() {
        return "admin/chat";
    }

    @RequestMapping(value = "user/chat", method = RequestMethod.GET)
    public String userChat() {
        return "user/chat";
    }
}
