package com.tan00xu.dao;


import com.tan00xu.pojo.User;
import com.tan00xu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void testListUsers(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.listUsers();
        //不推荐使用
        //List<User> userList = sqlSession.selectList("com.tan00xu.dao.UserDao.listUsers");

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }


    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);

        System.out.println(user);


        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void testInsertUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.insertUser(new User(null,"嘿嘿","123123"));

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userId",5);
        map.put("userPassword","55555");

        mapper.insertUser2(map);

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(8,"呵呵","666666"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(8);

        sqlSession.commit();
        sqlSession.close();
    }
}
