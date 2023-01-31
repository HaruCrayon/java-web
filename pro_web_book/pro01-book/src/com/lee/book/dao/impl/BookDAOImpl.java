package com.lee.book.dao.impl;

import com.lee.book.dao.BookDAO;
import com.lee.book.domain.Book;
import com.lee.myssm.basedao.TransBasicDAO;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class BookDAOImpl extends TransBasicDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        String sql = "select * from t_book where bookStatus=0";
        List<Book> bookList = super.queryMulti(sql, Book.class);

        return bookList;
    }

    @Override
    public Book getBookById(Integer id) {
        String sql = "select * from t_book where id=?";
        Book book = super.querySingle(sql, Book.class, id);

        return book;
    }
}
