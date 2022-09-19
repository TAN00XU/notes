package com.tan00xu;

import com.tan00xu.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author TAN00XU
 * @date 2022/09/19 16:01
 */
public class JedisTest {
    private Jedis jedis;


    @BeforeEach
    void setup() {
        //建立连接
//        jedis = new Jedis("192.168.132.128", 6379);
        jedis = JedisConnectionFactory.getJedis();
        //设置密码
//        jedis.auth("123123");
        //选择库
        jedis.select(0);
    }

    @Test
    void testHash() {
        //存入hash
        jedis.hset("user:1", "name", "张三");
        jedis.hset("user:1", "age", "18");
        //获取
        Map<String, String> stringStringMap = jedis.hgetAll("user:1");
        System.out.println(stringStringMap);
        String age = jedis.hget("user:1", "age");
        System.out.println(age);
    }

    @Test
    void testString() {
        //存入数据
        String set = jedis.set("name", "DrinkDream");
        System.out.println("set=>" + set);
        //获取数据
        String name = jedis.get("name");
        System.out.println("get=>" + name);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
