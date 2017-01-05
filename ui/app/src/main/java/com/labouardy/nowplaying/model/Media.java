package com.labouardy.nowplaying.model;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class Media {

    private String name;

    private String cover;

    public Media(){}

    public Media(String name, String cover) {
        this.name = name;
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return name + " " + cover;
    }
}
