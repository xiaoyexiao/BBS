package com.library.pojo;

import java.util.List;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/5/9 21:08
 */
public class Ebook {
    private int eid;
    private String name;
    private String author;
    private String image;

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    private List<Chapter> chapters;

    public Ebook() {
    }

    public Ebook(int eid, String name, String author, String image, List<Chapter> chapters) {
        this.eid = eid;
        this.name = name;
        this.author = author;
        this.image = image;
        this.chapters = chapters;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", chapters=" + chapters +
                '}';
    }
}
