package com.pkm.service.object;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private int id;
    private String title;
    private String details;
    private Date time;
    private String user_id;

    public Notice(int id, String title, String details, Date time, String user_id) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.time = time;
        this.user_id = user_id;
    }

    public Notice() {

    }

    @Override
    public String toString() {
        return "notice{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", time=" + time +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
