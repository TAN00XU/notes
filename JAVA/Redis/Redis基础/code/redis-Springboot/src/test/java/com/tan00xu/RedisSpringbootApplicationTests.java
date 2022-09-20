package com.tan00xu;

import com.tan00xu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class RedisSpringbootApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

//    @Test
//    void contextLoads() {
//        
//    }

    @Test
    void testString() {
        redisTemplate.opsForValue().set("time", new Date());
        Object time = redisTemplate.opsForValue().get("time");
        System.out.println("time=>" + time);

    }

    @Test
    void testSaveUser() {
        redisTemplate.opsForValue().set("user:0", new User("张三", 18));
        Object o = redisTemplate.opsForValue().get("user:0");
        System.out.println(o);
    }


}
