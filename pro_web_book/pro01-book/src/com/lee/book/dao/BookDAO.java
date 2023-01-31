package com.lee.book.dao;

import com.lee.book.domain.Book;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface BookDAO {
    //查询图书列表
    List<Book> getBookList();
    //根据id获取Book
    Book getBookById(Integer id);
}
