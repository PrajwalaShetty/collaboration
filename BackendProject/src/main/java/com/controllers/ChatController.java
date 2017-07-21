package com.controllers;


import java.util.Date;


import org.slf4j.*;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.model.Message;
import com.model.OutputMessage;

@Controller
@RequestMapping("/")
public class ChatController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @MessageMapping("/chat")
  @SendTo("/topic/message")
  public OutputMessage sendMessage(Message message) {
    logger.info("Message sent");
    return new OutputMessage(message ,new Date());
  }
}


//Msgmapping defines the route of msg {chat is my endpoint}address of endpoint
// send to defines to whom the msg is sent to 


// for private chat 

//@MessageMapping("/chat")
//@SendToUser("/user/queue/message")