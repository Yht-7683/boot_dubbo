package com.pkm.service.object;

import java.io.Serializable;

public class BallBag extends Ball implements Serializable {

    private int bagid;
    private int num;

    public BallBag(int id, String name, String img, double probability, int money, int bagid,int num) {
        super(id, name, img, probability, money);
        this.bagid=bagid;
        this.num = num;
    }

    @Override
    public String toString() {
        return "BallBag{" +"bagid='" + bagid + '\'' +
        "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", img='" + super.getImg() + '\'' +
                ", probability=" + super.getProbability() +
                ", money=" + super.getMoney() +
                "num=" + num +
                '}';
    }

    public int getBagid() {
        return bagid;
    }

    public void setBagid(int bagid) {
        this.bagid = bagid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BallBag() {

    }
}
