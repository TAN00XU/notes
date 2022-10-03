package com.tan00xu.springbootrabbitmqconsumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/03 21:11
 */
@Component
public class RabbitMQListener {

    @RabbitListener(queues = "springboot_queue")
    public void ListenerQueue(Message message) {
        System.out.println(new String(message.getBody()));
    }
}
