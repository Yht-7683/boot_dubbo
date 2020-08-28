package com.pkm.service.object;

import java.io.Serializable;

public class Ball_pack implements Serializable {
    private int id;
    private String user_id;
    private int ball_id;
    private int num;

    public Ball_pack(int id, String user_id, int ball_id, int num) {
        this.id = id;
        this.user_id = user_id;
        this.ball_id = ball_id;
        this.num = num;
    }
    public Ball_pack(){

    }

    @Override
    public String toString() {
        return "ball_pack{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", ball_id='" + ball_id + '\'' +
                ", num=" + num +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getBall_id() {
        return ball_id;
    }

    public void setBall_id(int ball_id) {
        this.ball_id = ball_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
