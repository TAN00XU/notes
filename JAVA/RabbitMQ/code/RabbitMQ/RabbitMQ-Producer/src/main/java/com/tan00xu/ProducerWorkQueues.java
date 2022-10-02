package com.tan00xu;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/02 20:20
 */
public class ProducerWorkQueues {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2. 设置参数
        //ip 默认localhost
        connectionFactory.setHost("47.109.33.195");
        //端口 默认5672
        connectionFactory.setPort(5672);
        //用户名 默认guest
        connectionFactory.setUsername("admin");
        //密码 默认guest
        connectionFactory.setPassword("admin");
        // 3. 创建连接
        Connection connection = connectionFactory.newConnection();
        // 4. 创建通道 channel
        Channel channel = connection.createChannel();
        // 5. 创建队列
        /**
         * queue -队列的名称
         * durable- true如果我们声明一个持久队列 (队列将在服务器重启后存活)
         * exclusive- true如果我们声明一个排他队列 (仅限于此连接)
         *   * 是否独占
         *   * 当Connection被关闭时，是否删除队列
         * autoDelete- true 如果我们声明了一个autoDelete队列(服务器将在不再使用时删除它)
         * arguments -队列的其他属性 (构造参数)
         */
        //如果没有一个名字叫HELLO_WORLD的队列，则会创建该队列，如果有则不会创建
        channel.queueDeclare("Work_Queues", true, false, false, null);
        // 6. 发送消息
        /**
         * exchange -将消息发布到
         *  * 交换机的名称。简单模式下回使用默认的""
         * routingKey -路由密钥 及名称
         * props -消息的其他属性-路由头等
         *  * 配置信息
         * body -消息正文
         */
        for (int i = 0; i < 10; i++) {
            String body = "hello 饮梦" + i;
            channel.basicPublish("", "Work_Queues", null, body.getBytes());
        }


        // 7. 释放资源
        channel.close();
        connection.close();
    }
}
