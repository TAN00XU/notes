package com.tan00xu.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 订阅模式
 *
 * @author 饮梦 TAN00XU
 * @date 2022/10/02 20:51
 */
public class Consumer_PubSub02 {
    public static void main(String[] args) throws IOException, TimeoutException {
        {
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
            // 5. 接收消息
            Consumer consumer = new DefaultConsumer(channel) {
                /**
                 * 回调方法，当收到消息后会自动执行该方法
                 * @param consumerTag 标识
                 * @param envelope 获取一些信息，交换机，路由key
                 * @param properties 消息的内容头数据
                 * @param body 消息体 (不透明的，特定于客户端的字节数组)
                 * @throws IOException
                 */
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("body=>" + new String(body));
                    System.out.println("=====日志信息保存到数据库=====");
                }
            };

            String queue1Name = "test_fanout_queue1";
            String queue2Name = "test_fanout_queue2";
            channel.basicConsume(queue2Name, true, consumer);


        }
    }
}
