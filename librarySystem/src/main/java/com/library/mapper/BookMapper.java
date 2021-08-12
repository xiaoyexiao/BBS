package com.library.mapper;

import com.library.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    Book getBookByID(@Param("bookID") String id);
    List<Book> listBooks();
    int insertBook(Book book);
    List<Book> getBookByKeyword(String keyword);
    Integer deleteBook(int bookID);
    List<String> listCategories();
}
