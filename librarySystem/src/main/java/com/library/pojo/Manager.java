package com.library.pojo;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/3/25 21:13
 */
public class Manager {
    private String name;
    private String number;
    private String password;
    private int image;

    public Manager() {
    }

    public Manager(String name, String number, String password, int image) {
        this.name = name;
        this.number = number;
        this.password = password;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", image=" + image +
                '}';
    }
}
