package com.library.service;

import com.alibaba.fastjson.JSONObject;
import com.library.mapper.BorrowMapper;
import com.library.mapper.StudentMapper;
import com.library.pojo.Borrow;
import com.library.pojo.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/3/27 17:09
 */
public class StudentServiceImpl implements StudentService{
    private StudentMapper mapper;
    private BorrowMapper borrowMapper;

    public void setMapper(StudentMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Student getStudentByID(String number) {
        return mapper.getStudentById(number);
    }

    @Override
    public int insertStudent(Student student) {
        return mapper.insertStudent(student);
    }


}
