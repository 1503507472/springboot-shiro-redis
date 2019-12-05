package com.aaa.mapper.book;

import com.aaa.model.BookInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:29
 */
@Mapper
public interface BookMapper {
    /**
     * 获取图书信息
     * @return
     */
    @Select("select * from book_info")
    List<BookInfo> getBookInfo();
    /**
     * 添加书籍
     * @param bookInfo
     */
    @Insert("insert into book_info(book_name,book_store,book_price) values (#{bookName},#{bookStore},#{bookPrice})")
    void addBook(BookInfo bookInfo);

    /**
     * 删除书籍
     * @param bookId
     */
    @Delete("delete from book_info where book_id=#{bookId}")
    void deleteBook(int bookId);
    /**
     * 修改
     * @param bookId
     * @return
     */
    @Select("select * from book_info where book_id=#{bookId}")
    List<BookInfo> getBook(int bookId);

    /**
     * 修改
     * @param bookInfo
     */
    @Update("update book_info set book_name = #{bookName},book_store = #{bookStore},book_price = #{bookPrice} where book_id = #{bookId}")
    void updateBook(BookInfo bookInfo);
}
