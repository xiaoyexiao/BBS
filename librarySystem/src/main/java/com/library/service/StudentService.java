package com.library.service;

import com.alibaba.fastjson.JSONObject;
import com.library.pojo.Student;

import java.util.List;

public interface StudentService {
    Student getStudentByID(String number);
    int insertStudent(Student student);

}
