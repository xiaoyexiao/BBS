package com.library.service;

import com.alibaba.fastjson.JSONObject;
import com.library.pojo.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BorrowService {
    List<Borrow> getBorrowBooksByStudentID(String number);
    int updateRecordOnVisible(int order);
    Borrow getBorrowRecordByBook(int number);
    List<JSONObject> getAllRecord();
    Integer saveBorrowRecord(String account, int bookID, Date date);
    Integer updateResting(int order);
}
