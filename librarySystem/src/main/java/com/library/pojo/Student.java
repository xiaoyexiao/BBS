package com.library.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/3/25 21:13
 */
public class Student {
    private String name;
    private String number;
    @JSONField(serialize = false)
    private String password;
    private String email;
    private String phone;
    private int grade;
    private int clazz;
    private String major;
    private String gender;
    private String nickname;
    private int image;

    public Student() {
    }

    public Student(String name, String number, String password, String email, String phone, int grade, int clazz, String major, String gender, String nickname, int image) {
        this.name = name;
        this.number = number;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.grade = grade;
        this.clazz = clazz;
        this.major = major;
        this.gender = gender;
        this.nickname = nickname;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", grade=" + grade +
                ", clazz=" + clazz +
                ", major='" + major + '\'' +
                ", gender='" + gender + '\'' +
                ", nickname='" + nickname + '\'' +
                ", image=" + image +
                '}';
    }
}
