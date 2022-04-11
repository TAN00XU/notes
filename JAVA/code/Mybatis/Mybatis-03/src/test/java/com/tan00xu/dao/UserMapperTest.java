package com.tan00xu.dao;


import com.tan00xu.pojo.User;
import com.tan00xu.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);



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
    public void testLog4j(){
        logger.info("info : 进入testLog4j");
        logger.debug("debug : 进入testLog4j");
        logger.error("error : 进入testLog4j");
    }


    @Test
    public void testListUsersByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",3);

        List<User> userList = mapper.listUsersByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testListUsersByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);

        //通过JAVA代码层面实现分页
        List<User> userList = sqlSession.selectList("com.tan00xu.dao.UserMapper.listUsersByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
