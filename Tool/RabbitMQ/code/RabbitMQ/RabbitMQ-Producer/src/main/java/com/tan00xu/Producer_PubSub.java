package com.tan00xu;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/02 20:20
 */
public class Producer_PubSub {
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
        // 5. 创建交换机
        /**
         * exchangeDeclare(String exchange,
         *         BuiltinExchangeType type,
         *         boolean durable,
         *         boolean autoDelete,
         *         boolean internal,
         *         Map<String, Object> arguments)
         * 参数：
         * exchange -交换机的名称
         * type -交换机的类型
         *   *  DIRECT("direct"),  定向
         *   *  FANOUT("fanout"),  扇形（广播），发送消息到没一个与之绑定的队列
         *   *  TOPIC("topic"),  通配符
         *   *  HEADERS("headers");  参数匹配
         * durable -持久化
         * autoDelete -是否自动删除
         * internal- true。内部使用，一般为false
         * arguments -参数
         */
        String exchangeName = "test_fanout";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT, true, false, null);
        // 6. 创建队列
        String queue1Name = "test_fanout_queue1";
        String queue2Name = "test_fanout_queue2";
        channel.queueDeclare(queue1Name, true, false, false, null);
        channel.queueDeclare(queue2Name, true, false, false, null);
        // 7. 绑定队列和交换机
        /**
         * queueBind(String queue, String exchange, String routingKey)
         * 参数：
         * queue -队列名称
         * exchange -交换机名称
         * routingKey -路由键，绑定规则
         *   *如果交换机的类型为fanout，routingKey设置为""
         */
        channel.queueBind(queue1Name, exchangeName, "");
        channel.queueBind(queue2Name, exchangeName, "");
        // 8. 发送消息
        String body = "日志信息:有人调用了findAll方法...日志级别:info...";
        channel.basicPublish(exchangeName, "", null, body.getBytes());

        // 9. 释放资源
        channel.close();
        connection.close();
    }
}
