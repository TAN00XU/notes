package com.tan00xu.dao;

import com.tan00xu.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {


    int insertBlog(Blog blog);


    //查询博客
    List<Blog> selectBlogIF(Map map);

    List<Blog> selectBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询1,2,3号博客
    List<Blog> selectBlogForEach(Map map);
}
