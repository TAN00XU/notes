package com.tan00xu.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 既然在了 SqiSessionFactory，顾名思义,我们就可以从中获得SqlSession的实例了。
     * SqlSession 完全包含了面向数据库执行5QL命令所击的所有方法。
     * 可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }

}
