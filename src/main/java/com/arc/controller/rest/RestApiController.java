package com.arc.controller.rest;

import com.arc.model.dto.ChatMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RestApiController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ChatMessage test() {
        List<String> messages = new ArrayList<String>();
        messages.add("Message1");
        messages.add("Message2");
        messages.add("Message3");
        return new ChatMessage(messages, "Sender 1");
    }
}
