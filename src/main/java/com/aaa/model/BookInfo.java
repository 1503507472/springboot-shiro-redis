package com.aaa.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:31
 */
public class BookInfo implements Serializable {
    private Long bookId;
    private String bookName;
    private Integer bookStore;
    private BigDecimal bookPrice;

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookStore=" + bookStore +
                ", bookPrice=" + bookPrice +
                '}';
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookStore() {
        return bookStore;
    }

    public void setBookStore(Integer bookStore) {
        this.bookStore = bookStore;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }
}
