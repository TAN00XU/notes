package com.tan00xu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.tan00xu.entity.User;
import com.tan00xu.mapper.UserMapper;
import com.tan00xu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author TAN00XU
 * @date 2022/09/20 14:28
 */
@SpringBootTest
public class MyBatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        //SELECT id,name,age,email,is_deleted
        // FROM user WHERE is_deleted=0
        // AND (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");

        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void testSelectSort() {
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        //SELECT id,name,age,email,is_deleted 
        // FROM user WHERE is_deleted=0 
        // ORDER BY age DESC,id ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void testDelete() {
        //删除邮箱地址为null的用户信息
        //UPDATE user SET is_deleted=1
        // WHERE is_deleted=0 AND (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        System.out.println(userMapper.delete(queryWrapper));
    }

    @Test
    public void testUpdate() {
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        //UPDATE user SET name=?, age=?, email=? WHERE is_deleted=0
        // AND (age > ? AND name LIKE ? OR email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                .like("name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("小菜");
        user.setAge(18);
        user.setEmail("xiaocai@tx.com");
        userMapper.update(user, queryWrapper);
    }

    @Test
    public void testLambda() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //lambda中的条件优先执行
        //UPDATE user SET name=?, email=? WHERE is_deleted=0
        // AND (name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("芜湖");
        user.setEmail("wuhu@tx.com");
        userMapper.update(user, queryWrapper);
    }

    @Test
    public void testSelectField() {
        //查询用户的用户名、年龄、邮箱信息
        //SELECT name,age,email FROM user WHERE is_deleted=0
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void testSubQuery() {
        //SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0
        // AND (id IN (select id from user where id<=100))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from user where id<=100");
        userMapper.selectList(queryWrapper).forEach(System.out::println);

    }

    @Test
    public void testUpdateWrapper() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //组装set子句以及修改条件
        //UPDATE user SET name=?,age=? WHERE is_deleted=0
        // AND (name LIKE ? AND (age > ? OR email IS NULL))
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .set("name", "呵呵")
                .set("age", 18)
                .like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));

        userMapper.update(null, updateWrapper);
    }

    @Test
    public void testNoCondition() {
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(username)) {
            //isNotBlank 判断字符串中是否不全是空白字符
            queryWrapper.like("name", username);
        }
        if (ageEnd != null) {
            queryWrapper.ge("age", ageBegin);
        }
        if (ageEnd != null) {
            queryWrapper.le("age", ageEnd);
        }
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void testCondition() {
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNotBlank(username), "name", username)
                .ge(ageEnd != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        userMapper.selectList(queryWrapper).forEach(System.out::println);

    }

    @Test
    public void testLambdaQueryWrapper() {
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageEnd != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        userMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    public void testLambdaUpdateWrapper() {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper
                .set(User::getName, "啊哈")
                .set(User::getAge, 18)
                .like(User::getName, "a")
                .and(i -> i.gt(User::getAge, 20).or().isNull(User::getEmail));
        userMapper.update(null, lambdaUpdateWrapper);
    }
}
