package com.tan00xu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/03 10:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-rabbitmq-producer.xml"})
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testHelloWorld() {
        //发送消息
        rabbitTemplate.convertAndSend("spring_queue", "hello world spring...");
    }

    /**
     * 发送fanout消息
     */
    @Test
    public void testFanout() {
        //发送消息
        rabbitTemplate.convertAndSend("spring_fanout_exchange", "", "hello world spring fanout...");
    }

    /**
     * 发送Topic消息
     */
    @Test
    public void testTopic() {
        //发送消息
        rabbitTemplate.convertAndSend("spring_topic_exchange", "heima.he.wuhu", "hello world spring Topic...");
    }
}
