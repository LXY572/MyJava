package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;


import java.util.List;

public interface BookDao {

    //增加一个Books
    int addBook(Books books);

    //根据id删除Books
    int deleteBookByID(@Param("bookID") int id);

    //更新Books
    int updateBook(Books books);

    //根据id查询Book
    Books queryBookByID(@Param("bookID") int id);

    //查看全部的Book
    List<Books> queryAllBook();


}
