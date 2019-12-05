package com.aaa.controller.book;

import com.aaa.model.BookInfo;
import com.aaa.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:29
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/getBookInfo")
    public String getBookInfo(ModelMap modelMap){
        System.out.println("获取全部书籍");
        List<BookInfo> bookInfo = bookService.getBookInfo();
        modelMap.addAttribute("books",bookInfo);
        return "index";
    }

    /**
     * 添加书籍
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(){
        return "addBook";
    }
    @RequestMapping("/add")
    public String addBookInfo(BookInfo bookInfo){
        bookService.addBook(bookInfo);
        return "redirect:/book/getBookInfo";
    }
    @RequestMapping("/delete")
    public String deleteBook(int bookId){
        bookService.deleteBook(bookId);
        return "redirect:/book/getBookInfo";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping("/update")
    public  String updateBook(ModelMap modelMap,int bookId){
        List<BookInfo> book = bookService.getBook(bookId);
        modelMap.addAttribute("books",book);
        return "update";
    }
    @RequestMapping("/up")
    public String update(BookInfo bookInfo){
        bookService.updateBook(bookInfo);
        return "redirect:/book/getBookInfo";
    }
}
