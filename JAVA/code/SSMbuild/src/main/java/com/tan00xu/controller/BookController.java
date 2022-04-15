package com.tan00xu.controller;

import com.tan00xu.pojo.Books;
import com.tan00xu.service.BookService;
import com.tan00xu.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    /**
     * 查询全部的书籍，并返回到书籍展示页面
     */
    @RequestMapping("/allBooks")
    public String listBooks(Model model){
        List<Books> books = bookService.listBooks();
        model.addAttribute("books",books);
        return "allBooks";
    }

    /**
     * 跳转到增加书籍页面
     */
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    /**
     * 处理添加书籍的请求
     */
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("前端的数据："+books);
        bookService.addBook(books);

        return "redirect:/book/allBooks";
    }

    /**
     * 跳转到修改书籍页面
     */
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id,Model model){
        Books book = bookService.selectBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    /**
     * 处理修改书籍的请求
     */
    @RequestMapping("/updateBook")
    public String updateBook(Books book){
        bookService.updateBook(book);
        return "redirect:/book/allBooks";
    }

    /**
     * 处理删除书籍的请求
     */
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBooks";
    }

    /**
     * 处理查询书籍的请求
     */
    @RequestMapping("/selectBookByName")
    public String selectBook(String bookName,Model model){
        Books book = bookService.selectBookByName(bookName);
        List<Books> books = new ArrayList<Books>();
        books.add(book);
        if (book == null) {
            books = bookService.listBooks();
            model.addAttribute("error","没有查询到相关书籍");
        }

        model.addAttribute("books",books);

        return "allBooks";
    }
}
