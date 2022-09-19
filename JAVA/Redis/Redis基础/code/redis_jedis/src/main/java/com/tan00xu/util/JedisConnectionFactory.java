package com.tan00xu.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * Jedis连接工厂类
 *
 * @author TAN00XU
 * @date 2022/09/19
 */
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static {
        //配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);
        jedisPoolConfig.setMaxIdle(3);
        jedisPoolConfig.setMinIdle(0);
        jedisPoolConfig.setMaxWait(Duration.ofMillis(100));
//        jedisPoolConfig.setMaxWaitMillis();

        //创建连接池对象
        jedisPool = new JedisPool(
                jedisPoolConfig,
                "192.168.132.128",
                6379,
                1000,
                "123123"
        );
    }

    
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
