package com.library.pojo;

/**
 * @author ：Vizzk
 * @description：Book类
 * @date ：2021/3/25 19:09
 */
public class Book {
    private int no;
    private String name;
    private String author;
    private String category;
    private String publisher;
    private String summary;
    private String publishDate;
    private int image;
    private int length;
    private String located;

    public Book() {

    }

    public Book(int no, String name, String author, String category, String publisher, String summary, String publishDate, int image, int length, String located) {
        this.no = no;
        this.name = name;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.summary = summary;
        this.publishDate = publishDate;
        this.image = image;
        this.length = length;
        this.located = located;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getLocated() {
        return located;
    }

    public void setLocated(String located) {
        this.located = located;
    }

    @Override
    public String toString() {
        return "Book{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publisher='" + publisher + '\'' +
                ", summary='" + summary + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", image=" + image +
                ", length=" + length +
                ", located='" + located + '\'' +
                '}';
    }
}

