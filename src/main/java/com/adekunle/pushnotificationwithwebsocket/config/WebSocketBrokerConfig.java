package com.adekunle.pushnotificationwithwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry brokerRegistry) {
        brokerRegistry.enableSimpleBroker("/all", "/specific"); //this is setting the destinations to which messages will be broadcasted in this case 2 destinations for all users and specific user
        brokerRegistry.setApplicationDestinationPrefixes("/app"); //this is the request mapping
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws"); //the ws(webSocket)  is the endpoint through which th connection will be made.
        registry.addEndpoint("/ws").withSockJS();// this is an alternative registry if browser support is not available for websocket connection it falls back to sockJs connection.
    }
}
