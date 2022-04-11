package com.tan00xu.dao;

import com.tan00xu.pojo.Blog;
import com.tan00xu.utils.IDUtils;
import com.tan00xu.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BlogMapperTest extends TestCase {

    public void testInsertBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.insertBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java");
        mapper.insertBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring");
        mapper.insertBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务");
        mapper.insertBlog(blog);

        sqlSession.close();
    }

    @Test
    public void testSelectBlogIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","Java");
        map.put("author","狂神说");
        mapper.selectBlogIF(map).forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectBlogChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("view",9999);

        mapper.selectBlogIF(map).forEach(System.out::println);
        sqlSession.close();

        sqlSession.close();


    }

    @Test
    public void testSelectBlogForEach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        map.put("ids",ids);

        mapper.selectBlogForEach(map).forEach(System.out::println);

        sqlSession.close();
    }
}