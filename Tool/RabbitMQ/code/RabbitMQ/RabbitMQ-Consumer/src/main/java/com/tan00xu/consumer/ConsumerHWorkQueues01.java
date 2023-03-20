package com.tan00xu.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 工作队列模式
 *
 * @author 饮梦 TAN00XU
 * @date 2022/10/02 20:51
 */
public class ConsumerHWorkQueues01 {
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
            // 6. 接收消息
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
                    System.out.println("=========这里是ConsumerHWorkQueues01=========");
                    System.out.println("body=>" + new String(body));
                }
            };

            /**
             * queue -队列名称
             * autoAck -如果服务器应考虑消息传递后已确认，则为true; 如果服务器应期望显式确认，则为false
             *   * 是否自动确认
             * callback consumer对象的接口 回调对象
             */
            channel.basicConsume("Work_Queues", true, consumer);

            // 7. 不关闭资源
//            channel.close();
//            connection.close();
        }
    }
}
