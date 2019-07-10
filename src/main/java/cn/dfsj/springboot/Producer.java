/*
package cn.dfsj.springboot;


import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String massage = "HelloRabbitMQ";
        rabbitTemplate.convertAndSend("hello",massage);
    }
}*/
