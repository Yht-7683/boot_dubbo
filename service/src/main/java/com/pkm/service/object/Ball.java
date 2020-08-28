package com.pkm.service.object;

import java.io.Serializable;

public class Ball implements Serializable {
    private int id;
    private String name;
    private String img;
    private double probability;
    private int money;

    public Ball(int id, String name, String img, double probability, int money) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.probability = probability;
        this.money = money;
    }
    public Ball(){

    }

    @Override
    public String toString() {
        return "ball{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", probability=" + probability +
                ", money=" + money +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
