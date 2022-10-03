package com.tan00xu.springbootrabbitmqproducer.com.tan00xu;

import com.tan00xu.springbootrabbitmqproducer.rabbitmq.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/03 20:47
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {
    // 1. 注入RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "boot.hello", "springboot mq hello~~");
    }

}
