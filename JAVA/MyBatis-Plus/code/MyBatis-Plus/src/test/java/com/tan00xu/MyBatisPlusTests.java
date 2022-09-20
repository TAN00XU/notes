package com.tan00xu;

import com.tan00xu.mapper.UserMapper;
import com.tan00xu.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author TAN00XU
 * @date 2022/09/19 23:41
 */
@SpringBootTest
public class MyBatisPlusTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        //selectList()根据MyBatis-Plus内置的条件构造器查询一个list集合，null表示没有条件，即查询所有
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 测试插入
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setEmail("zhangsan@66.com");
        int insert = userMapper.insert(user);
        System.out.println("insert=>" + insert);
        System.out.println("userId=>" + user.getId());
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        //通过id删除用户信息
//        int i = userMapper.deleteById(1572025049776680962L);
//        System.out.println("result=>" + i);

        //根据map集合中设置的条件删除用户信息
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", "张三");
//        map.put("age", 18);
//        userMapper.deleteByMap(map);

        //通过多个id实现批量删除
//        List<Long> list = Arrays.asList(1L, 2L, 3L);
//        userMapper.deleteBatchIds(list);
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@66.com");
        userMapper.updateById(user);
    }

    /**
     * 测试选择
     */
    @Test
    public void testSelect() {
        //通过id查询用户信息 SELECT id,name,age,email FROM user WHERE id=?
//        User user = userMapper.selectById(1L);
//        System.out.println(user);

        //根据多个id查询多个用户信息
//        List<Long> list = Arrays.asList(1L, 2L, 3L);
//        userMapper.selectBatchIds(list).forEach(System.out::println);

        //根据map集合中的条件查询
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("age", 21);
//        List<User> users = userMapper.selectByMap(map);
//        users.forEach(System.out::println);

        //查所有
//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);

        Map<String, Object> stringObjectMap = userMapper.selectMapById(1L);
        System.out.println(stringObjectMap);
    }
}
