package com.tan00xu.dao;

import com.tan00xu.pojo.User;
import com.tan00xu.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest extends TestCase {

    @Test
    public void testSelectUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectUserById(2);
        System.out.println(user);

        System.out.println("===================");

        User user2 = mapper.selectUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);
        sqlSession.close();
    }


}