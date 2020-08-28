package com.pkm.service.object;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PkmBag extends Pokemon implements Serializable {
    private int bagid;
    private Date meetTime;
    private int LV;

    public PkmBag(int id, String name, String img, String type, String ability, String others, Date meetTime, int LV,int bagid) {
        super(id, name, img, type, ability, others);
        this.meetTime = meetTime;
        this.LV = LV;
        this.bagid=bagid;
    }
    public PkmBag(Pokemon pokemon, Date meetTime, int LV) {
        super(pokemon.getId(), pokemon.getName(), pokemon.getImg(), pokemon.getType(), pokemon.getAbility(), pokemon.getOthers());
        this.meetTime = meetTime;
        this.LV = LV;
    }

    @Override
    public String toString() {
        return "PkmBag{" +"id=" + bagid+ '\''  +"id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", img='" + super.getImg() + '\'' +
                ", type='" + super.getType() + '\'' +
                ", ability='" + super.getAbility() + '\'' +
                ", others='" + super.getOthers() + '\'' +
                "meetTime=" + meetTime +
                ", LV=" + LV +
                '}';
    }

    public PkmBag() {
    }

    public int getBagid() {
        return bagid;
    }

    public void setBagid(int bagid) {
        this.bagid = bagid;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getMeetTime() {
        return meetTime;
    }

    public void setMeetTime(Date meetTime) {
        this.meetTime = meetTime;
    }

    public int getLV() {
        return LV;
    }

    public void setLV(int LV) {
        this.LV = LV;
    }
}
