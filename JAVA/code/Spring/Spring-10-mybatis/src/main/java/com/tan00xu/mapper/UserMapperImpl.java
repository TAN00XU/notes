package com.tan00xu.mapper;

import com.tan00xu.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> listUsers() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.listUsers();
    }
}
