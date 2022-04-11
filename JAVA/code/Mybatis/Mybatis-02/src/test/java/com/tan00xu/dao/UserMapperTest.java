package com.tan00xu.dao;


import com.tan00xu.pojo.User;
import com.tan00xu.utils.MybatisUtils;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

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


}
