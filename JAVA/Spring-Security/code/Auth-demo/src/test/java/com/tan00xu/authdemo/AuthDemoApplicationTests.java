package com.tan00xu.authdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tan00xu.authdemo.dao.UserDao;
import com.tan00xu.authdemo.domain.User;
import com.tan00xu.authdemo.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class AuthDemoApplicationTests {

    @Test
    void contextLoads() throws Exception {
//        System.out.println(JwtUtil.createJWT("测试"));
        Claims claims = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2MDFmY2E5YWUxMTQ0N2M4ODExZGRmNmZiMjg0YjUyOCIsInN1YiI6Iua1i-ivlSIsImlzcyI6IlRBTjAwWFUiLCJpYXQiOjE2NjUzNzU0MTcsImV4cCI6MTY2NTM3OTAxN30.vQbxtJTSZNYNsqIPAsP2i0PWyz1acmK1Ciz8ixtq0Dg");
        System.out.println(claims.getSubject());
    }

    @Autowired
    UserDao userDao;

    @Test
    void test() {
//        for (User user : userDao.selectList(null)) {
//            System.out.println(user);
//        }
//        User user1 = new User();
//        user1.setUserName("test");
//        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        userLambdaQueryWrapper.eq(User::getUserName, user1.getUserName());
//        User user = userDao.selectOne(userLambdaQueryWrapper);
//        System.out.println(user);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.lambda().eq(User::getUserName, "test");
        List<User> users = userDao.selectList(userQueryWrapper);
        System.out.println(users.get(0));
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void testBCrypt() {
        String encode = passwordEncoder.encode("123123");
        System.out.println(encode);
    }

}
