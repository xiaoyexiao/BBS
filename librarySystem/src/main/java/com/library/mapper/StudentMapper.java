package com.library.mapper;

import com.library.pojo.Student;

import java.util.List;

public interface StudentMapper {
    Student getStudentById(String number);
    int insertStudent(Student student);
    List<Student> getAllStudent();
    String getStudentName(String number);
}
