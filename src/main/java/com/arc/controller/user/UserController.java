package com.arc.controller.user;

import com.arc.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String userChat() {
        return getUserView("chat");
    }
}
