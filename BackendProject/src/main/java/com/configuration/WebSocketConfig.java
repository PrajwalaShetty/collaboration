package com.configuration;

import org.springframework.context.annotation.*;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages = "com")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
	  System.out.println("CONGIGURE MESSAGE BROKER");
    config.enableSimpleBroker("/topic");
//    config.enableSimpleBroker("/topic","queue");

    config.setApplicationDestinationPrefixes("/app");
  }

   
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat").withSockJS();
  }
}
