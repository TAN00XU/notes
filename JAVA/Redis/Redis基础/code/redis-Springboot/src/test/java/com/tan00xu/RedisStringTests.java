package com.tan00xu;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tan00xu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TAN00XU
 * @date 2022/09/19 20:41
 */
@SpringBootTest
public class RedisStringTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testString() {
        stringRedisTemplate.opsForValue().set("key", "value");
        String key = stringRedisTemplate.opsForValue().get("key");
        System.out.println(key);
    }

    public static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testSaveUser() throws JsonProcessingException {
        User user = new User("李四", 18);
        //手动序列化
//        String json = mapper.writeValueAsString(user);
        String json = JSON.toJSONString(user);
        stringRedisTemplate.opsForValue().set("user:111", json);
        String jsonUser = stringRedisTemplate.opsForValue().get("user:100");
        //手动反序列化
//        User user1 = mapper.readValue(jsonUser, User.class);
        User user1 = JSON.parseObject(jsonUser, User.class);
        System.out.println(user1);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:222", "name", "王五");
        stringRedisTemplate.opsForHash().put("user:222", "age", "22");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:222");
        entries.forEach((K, V) -> System.out.printf("%s--%s", K, V));

    }
}
