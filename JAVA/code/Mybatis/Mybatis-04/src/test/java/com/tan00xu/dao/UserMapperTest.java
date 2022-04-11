package com.tan00xu.dao;

import com.tan00xu.pojo.User;
import com.tan00xu.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest extends TestCase {

    @Test
    public void testListUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.listUsers().forEach(System.out::println);

//        mapper.insertUser(new User(null,"添加","2223"));

        sqlSession.close();
    }
}