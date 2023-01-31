package com.lee.book.service;

import com.lee.book.domain.Book;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface BookService {
    List<Book> getBookList();
    Book getBookById(Integer id);
}
