package com.pkm.service.object;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private int id;
    private String name;
    private String img;
    private String type;
    private String ability;
    private String others;

    public Pokemon(int id, String name, String img, String type, String ability, String others) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.type = type;
        this.ability = ability;
        this.others = others;
    }

    public Pokemon() {
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", type='" + type + '\'' +
                ", ability='" + ability + '\'' +
                ", others='" + others + '\'' +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
