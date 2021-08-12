package com.library.service;

import com.alibaba.fastjson.JSONObject;
import com.library.pojo.Book;

import java.util.List;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/3/25 19:57
 */
public interface BookService {

    Book getBookByID(String id);
    List<Book> listBooks();
    int insertBook(Book book);
    List<Book> getBookByKeyword(String keyword);
    Integer deleteBook(int bookID);
    JSONObject countCategories();
}
