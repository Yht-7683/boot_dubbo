package com.pkm.service.object;

import java.io.Serializable;

public class Bag implements Serializable {
    private String id;
    private String name;
    private int pkmNum;
    private int ballNum;

    public Bag(String id, String name, int pkmNum, int ballNum) {
        this.id = id;
        this.name = name;
        this.pkmNum = pkmNum;
        this.ballNum = ballNum;
    }

    public Bag() {
    }

    @Override
    public String toString() {
        return "Bag{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pkmNum=" + pkmNum +
                ", ballNum=" + ballNum +
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

    public int getPkmNum() {
        return pkmNum;
    }

    public void setPkmNum(int pkmNum) {
        this.pkmNum = pkmNum;
    }

    public int getBallNum() {
        return ballNum;
    }

    public void setBallNum(int ballNum) {
        this.ballNum = ballNum;
    }
}
