package com.arc.model.dto;

import java.util.List;

public class ChatMessage {
    private List<String> messages;
    private String sender;

    public ChatMessage(List<String> messages, String sender) {
        this.messages = messages;
        this.sender = sender;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
