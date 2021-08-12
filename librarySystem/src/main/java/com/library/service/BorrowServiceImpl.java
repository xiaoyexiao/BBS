package com.library.service;

import com.alibaba.fastjson.JSONObject;
import com.library.mapper.BorrowMapper;
import com.library.mapper.StudentMapper;
import com.library.pojo.Borrow;
import com.library.utils.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/4/5 12:00
 */
public class BorrowServiceImpl implements BorrowService{
    private BorrowMapper mapper;
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) { this.studentMapper = studentMapper; }

    public void setMapper(BorrowMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    //查阅借书记录
    public List<Borrow> getBorrowBooksByStudentID(String number) {
        return mapper.getBorrowBooksByStudentID(number);
    }

    @Override
    public int updateRecordOnVisible(int order){
        return mapper.updateRecordOnVisible(order);
    }

    @Override
    public Borrow getBorrowRecordByBook(int number) {return mapper.getBorrowRecordByBook(number);}

    @Override
    public List<JSONObject> getAllRecord() {
        List<Borrow> list = mapper.getAllRecord();
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<JSONObject> result = new ArrayList<>();

        list.forEach(record -> {
            try {
                JSONObject json = new JSONObject();
                String name = studentMapper.getStudentName(record.getStudentNo());
                //未归还
                if(!record.isStatus()){
                    Date date = df.parse(record.getBorrowDate());
                    int rest = Util.getRestDay(date,record.getResting());
                    record.setResting(rest);
                }
                json.put("name",name);
                json.put("record",record);
                result.add(json);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        return result;
    }

    @Override
    public Integer saveBorrowRecord(String account, int bookID, Date date) {
        return mapper.saveBorrowRecord(account, bookID, date);
    }

    @Override
    public Integer updateResting(int order) {
        return mapper.updateResting(order);
    }
}
