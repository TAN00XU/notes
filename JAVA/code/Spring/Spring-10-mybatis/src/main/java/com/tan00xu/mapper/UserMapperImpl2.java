package com.tan00xu.mapper;

import com.tan00xu.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public List<User> listUsers() {
//        return getSqlSession().selectList("com.tan00xu.mapper.UserMapper.listUsers");
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.listUsers();
//        return getSqlSession().getMapper(UserMapper.class).listUsers();
    }
}