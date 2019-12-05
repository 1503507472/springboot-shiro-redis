package com.aaa.service.book;

import com.aaa.model.BookInfo;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:27
 */
public interface BookService {
    /**
     * 获取图书信息
     * @return
     */
    List<BookInfo> getBookInfo();

    /**
     * 添加书籍
     * @param bookInfo
     */
    void addBook(BookInfo bookInfo);

    /**
     * 删除书籍
     * @param bookId
     */
    void deleteBook(int bookId);

    /**
     * 修改
     * @param bookId
     * @return
     */
    List<BookInfo> getBook(int bookId);

    /**
     * 修改
     * @param bookInfo
     */
    void updateBook(BookInfo bookInfo);
}
