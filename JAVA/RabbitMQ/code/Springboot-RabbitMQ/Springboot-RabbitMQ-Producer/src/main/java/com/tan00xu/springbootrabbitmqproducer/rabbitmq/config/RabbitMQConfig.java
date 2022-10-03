package com.tan00xu.springbootrabbitmqproducer.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/03 14:25
 */
@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "springboot_topic_exchange";
    public static final String QUEUE_NAME = "springboot_queue";

    // 1. 交换机
    @Bean("bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    // 2. 队列
    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    // 3. 队列和交换机绑定
    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue bootQueue, @Qualifier("bootExchange") Exchange bootExchange) {
//        return BindingBuilder.bind(bootQueue()).to(bootExchange()).with("boot.#").noargs();
        return BindingBuilder.bind(bootQueue).to(bootExchange).with("boot.#").noargs();

    }

}
