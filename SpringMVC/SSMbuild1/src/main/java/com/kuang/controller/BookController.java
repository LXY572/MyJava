package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //展示全部的书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到新增书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    //增加书籍页面
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("调试信息addBook===="+books);
        bookService.addBook(books);
        return "redirect:/book/allBook"; //重定向到首页
    }

    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookByID(id);
        System.out.println("调试信息toUpdateBook===="+books);
        model.addAttribute("book",books);
        return "redirect:updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books,Model model){
        System.out.println("调试信息updateBook===="+books);
        bookService.updateBook(books);
        //更新最新的书籍
        Books books1 = bookService.queryBookByID(books.getBookID());
        model.addAttribute("books",books1);
        System.out.println("修改后的书籍===="+books1);
        return "redirect:/book/allBook"; //重定向到首页
    }


    //删除书籍,请使用restful风格
    @RequestMapping("/del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBookByID(id);
        return "redirect:/book/allBook"; //重定向到首页
    }

}
