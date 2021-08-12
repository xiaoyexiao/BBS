package com.library.pojo;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/5/7 19:19
 */
public class Collect {
    private int collectID;
    private String studentID;
    private Book book;

    public Collect() {
    }


    public Collect(int collectID, String studentID, Book book) {
        this.collectID = collectID;
        this.studentID = studentID;
        this.book = book;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCollectID() {
        return collectID;
    }

    public void setCollectID(int collectID) {
        this.collectID = collectID;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "collectID=" + collectID +
                ", studentID='" + studentID + '\'' +
                ", book=" + book +
                '}';
    }
}
