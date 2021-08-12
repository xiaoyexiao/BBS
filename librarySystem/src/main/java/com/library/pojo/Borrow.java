package com.library.pojo;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/3/30 11:08
 */
public class Borrow {
    private String studentNo;
    private String borrowDate;
    private int resting;
    private boolean visible;
    private int order;
    private Book book;
    private boolean status;

    public Borrow() {
    }

    public Borrow(String studentNo, String borrowDate, int resting, boolean visible, int order, Book book, boolean status) {
        this.studentNo = studentNo;
        this.borrowDate = borrowDate;
        this.resting = resting;
        this.visible = visible;
        this.order = order;
        this.book = book;
        this.status = status;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getResting() {
        return resting;
    }

    public void setResting(int resting) {
        this.resting = resting;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "studentNo='" + studentNo + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", resting=" + resting +
                ", visible=" + visible +
                ", order=" + order +
                ", book=" + book +
                ", status=" + status +
                '}';
    }
}
