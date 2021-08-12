package com.library.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.library.pojo.Book;
import com.library.pojo.Borrow;
import com.library.pojo.ResultInfo;
import com.library.service.BookService;
import com.library.service.BookServiceImpl;
import com.library.service.BorrowService;
import com.library.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/5/5 9:48
 */
@Controller
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("borrowServiceImpl")
    private BorrowService borrowService;

    @ResponseBody
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String listAllBook(){
        List<Book> books = bookService.listBooks();
        final List<JSONObject> list = new ArrayList();
        books.forEach(book -> {
            Borrow record = borrowService.getBorrowRecordByBook(book.getNo());

            JSONObject data = new JSONObject();
            data.put("book",book);
            if(record != null){
                try {
                    String deadline = Util.getDeadline(record.getBorrowDate(), record.getResting());
                    data.put("status", false);
                    data.put("deadline", deadline);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else{
                data.put("status", true);
            }
            list.add(data);
        });
        ResultInfo response = new ResultInfo("success",0);
        response.setData(list);
        return JSONObject.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public String insertBook(@RequestBody JSONObject request){
        ResultInfo response = new ResultInfo("success", 0);

        Book book = JSONObject.toJavaObject(request, Book.class);
        int result = bookService.insertBook(book);
        if(result != 1){
            response.setEvent(1);
            response.setMsg("fail");
        }

        return JSONObject.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/searchBook", method = RequestMethod.GET)
    public String searchBook(String keyword){
        ResultInfo response = new ResultInfo("success", 0);

        final List<JSONObject> list = new ArrayList();
        List<Book> books = bookService.getBookByKeyword(keyword);
        books.stream().forEach(book -> {
            Borrow record = borrowService.getBorrowRecordByBook(book.getNo());
            JSONObject data = new JSONObject();
            data.put("book",book);
            if(record != null){
                try {
                    String deadline = Util.getDeadline(record.getBorrowDate(), record.getResting());
                    data.put("status", false);
                    data.put("deadline", deadline);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else{
                data.put("status", true);
            }
            list.add(data);
        });
        response.setData(list);

        return JSONObject.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public String deleteBook(int bookID){
        ResultInfo response = new ResultInfo("success", 0);

        int result = bookService.deleteBook(bookID);
        if(result == 0){
            response.setEvent(1);
            response.setMsg("fail");
        }

        return JSONObject.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/countCategories", method = RequestMethod.GET)
    public String countcategories(){
        ResultInfo response = new ResultInfo("success", 0);

        JSONObject categories = bookService.countCategories();
        response.setData(categories);
        return JSONObject.toJSONString(response);
    }
}
