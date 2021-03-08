package com.kuang.service;

import com.kuang.dao.BookDao;
import com.kuang.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {
    //组合Dao
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public int addBook(Books books) {
        return bookDao.addBook(books);
    }

    @Override
    public int deleteBookByID(int id) {
        return bookDao.deleteBookByID(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookDao.updateBook(books);
    }

    @Override
    public Books queryBookByID(int id) {
        return bookDao.queryBookByID(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookDao.queryAllBook();
    }
}
