package com.lee.book.controllers;

import com.lee.book.domain.Book;
import com.lee.book.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class BookController {
    private BookService bookService;

    public String index(HttpSession session) {
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList", bookList);

        return "index";
    }
}
