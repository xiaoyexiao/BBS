package com.library.mapper;

import com.library.pojo.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BorrowMapper {
    List<Borrow> getBorrowBooksByStudentID(String number);
    int updateRecordOnVisible(int order);
    Borrow getBorrowRecordByBook(int number);
    List<Borrow> getAllRecord();
    Integer updateResting(int order);
    Integer saveBorrowRecord(@Param("account") String account, @Param("bookID") int bookID, @Param("date")Date date);
}
