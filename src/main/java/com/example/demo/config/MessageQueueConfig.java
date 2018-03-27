package com.example.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;


@EnableJms
@Configuration
public class MessageQueueConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("inmemory.queue");
    }

}
