package com.library.service;

import com.alibaba.fastjson.JSONObject;
import com.library.mapper.BorrowMapper;
import com.library.mapper.ManagerMapper;
import com.library.mapper.StudentMapper;
import com.library.pojo.Borrow;
import com.library.pojo.Manager;
import com.library.pojo.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/3/28 20:05
 */
public class ManagerServiceImpl implements ManagerService{
    private ManagerMapper mapper;
    private BorrowMapper borrowMapper;
    private StudentMapper studentMapper;

    public void setMapper(ManagerMapper mapper) {
        this.mapper = mapper;
    }

    public void setBorrowMapper(BorrowMapper borrowMapper) { this.borrowMapper = borrowMapper; }

    public void setStudentMapper(StudentMapper studentMapper) { this.studentMapper = studentMapper; }

    @Override
    public Manager getManagerByID(String number) {
        return mapper.getManagerByID(number);
    }

    @Override
    public List<JSONObject> getAllStudentInfo() {
        List<Student> students = studentMapper.getAllStudent();

        List<JSONObject> studentInfo = new ArrayList<>();
        students.forEach(student -> {
            List<Borrow> list = borrowMapper.getBorrowBooksByStudentID(student.getNumber());
            long totalNumber = list.stream().count();
            long borrowingNumber = list.stream().filter(record -> {return !record.isStatus();}).count();
            JSONObject json = new JSONObject();
            json.put("student",student);
            json.put("total", totalNumber);
            json.put("borrowingNumber", borrowingNumber);
            studentInfo.add(json);
        });

        return studentInfo;
    }
}
