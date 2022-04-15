package com.tan00xu.service;

import com.tan00xu.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    /**
     * 增加一本书
     * @return 影响条数
     */
    int addBook(Books book);

    /**
     *  删除一本书
     *  @return 影响条数
     */
    int deleteBook(@Param("bookId") int id);

    /**
     * 更新一本书
     * @return 影响条数
     */
    int updateBook(Books book);

    /**
     * 查询一本书
     * @return 一本书籍的信息
     */
    Books selectBookById(int id);

    /**
     * 查询所有书
     * @return 所有书籍的信息的集合
     */
    List<Books> listBooks();

    /**
     *根据书名查询书
     */
    Books selectBookByName(String bookName);
}
