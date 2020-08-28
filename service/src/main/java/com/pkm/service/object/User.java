package com.pkm.service.object;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String id;
    private String name;
    private String photo;
    private String password;
    private String phone;
    private String state;
    private String role;
    private String sex;
    private Date registTime;
    private int money;

    public User(String id, String name, String photo, String password, String phone, String state, String role, String sex, Date registTime, int money) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.password = password;
        this.phone = phone;
        this.state = state;
        this.role = role;
        this.sex = sex;
        this.registTime = registTime;
        this.money = money;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", role='" + role + '\'' +
                ", sex='" + sex + '\'' +
                ", registTime=" + registTime +
                ", money=" + money +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
