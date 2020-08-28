package com.pkm.service.object;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Pkm_pack implements Serializable {
    private int id;
    private String user_id;
    private int pokemon_id;
    private Date meetTime;
    private int LV;

    public Pkm_pack(int id, String user_id, int pokemon_id, Date meetTime, int LV) {
        this.id = id;
        this.user_id = user_id;
        this.pokemon_id = pokemon_id;
        this.meetTime = meetTime;
        this.LV = LV;
    }

    public Pkm_pack() {
    }

    @Override
    public String toString() {
        return "pkm_pack{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", pokemon_id=" + pokemon_id +
                ", meetTime=" + meetTime +
                ", LV=" + LV +
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

    public int getPokemon_id() {
        return pokemon_id;
    }

    public void setPokemon_id(int pokemon_id) {
        this.pokemon_id = pokemon_id;
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
