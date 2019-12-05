package com.aaa.service.book.impl;

import com.aaa.mapper.book.BookMapper;
import com.aaa.model.BookInfo;
import com.aaa.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:28
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<BookInfo> getBookInfo() {
        List<BookInfo> bookInfo = bookMapper.getBookInfo();
        return bookInfo;
    }

    @Override
    public void addBook(BookInfo bookInfo) {
        bookMapper.addBook(bookInfo);
    }

    @Override
    public void deleteBook(int bookId) {
        bookMapper.deleteBook(bookId);
    }

    @Override
    public List<BookInfo> getBook(int bookId) {
        List<BookInfo> book = bookMapper.getBook(bookId);
        return book;
    }

    @Override
    public void updateBook(BookInfo bookInfo) {
        bookMapper.updateBook(bookInfo);
    }
}
