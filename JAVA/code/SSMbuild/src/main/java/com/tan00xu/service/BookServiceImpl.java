package com.tan00xu.service;

import com.tan00xu.dao.BookMapper;
import com.tan00xu.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {

    /**
     * service调用dao层的方法
     */
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Books book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Books selectBookById(int id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    public List<Books> listBooks() {
        return bookMapper.listBooks();
    }

    @Override
    public Books selectBookByName(String bookName) {
        return bookMapper.selectBookByName(bookName);
    }
}
