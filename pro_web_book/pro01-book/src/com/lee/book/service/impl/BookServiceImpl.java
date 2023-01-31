package com.lee.book.service.impl;

import com.lee.book.dao.BookDAO;
import com.lee.book.domain.Book;
import com.lee.book.service.BookService;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        List<Book> bookList = bookDAO.getBookList();

        return bookList;
    }

    @Override
    public Book getBookById(Integer id) {
        Book book = bookDAO.getBookById(id);
        return book;
    }
}
