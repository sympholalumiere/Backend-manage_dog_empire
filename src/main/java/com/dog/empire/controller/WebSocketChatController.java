package com.dog.empire.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class WebSocketChatController {
    @MessageMapping("/resume")
    @SendTo("/start/initial")
    public String chat(String msg) {
        System.out.println(msg);
        return msg;
    }

}
