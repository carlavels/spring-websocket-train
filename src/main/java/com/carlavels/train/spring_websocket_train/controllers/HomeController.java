package com.carlavels.train.spring_websocket_train.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.carlavels.train.spring_websocket_train.model.Payload;
import com.carlavels.train.spring_websocket_train.model.Response;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
    
    @MessageMapping("/home")
    @SendTo("/subscribe/deliver")
    public Response deliverResponse(Payload payload) throws Exception {
        log.info("Payload: {} --- {}", payload.getCaseId(), payload.getMessage());

        Thread.sleep(500);
        return new Response(
            HtmlUtils.htmlEscape(payload.getCaseId()), 
            "Successfully processed Payload!!!"
        );
    }

    
}
