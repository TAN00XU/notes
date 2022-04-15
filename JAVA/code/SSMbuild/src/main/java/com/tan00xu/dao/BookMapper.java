package com.tan00xu.dao;

import com.tan00xu.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    /**
     * 增加一本书
     */
    int addBook(Books book);

    /**
     *  删除一本书
     */
    int deleteBook(@Param("bookId") int id);

    /**
     * 更新一本书
     */
    int updateBook(Books book);

    /**
     * 查询一本书
     */
    Books selectBookById(@Param("bookID") int bookID);

    /**
     * 查询所有书
     */
    List<Books> listBooks();

    /**
     *根据书名查询书
     */
    Books selectBookByName(@Param("bookName") String bookName);
}
