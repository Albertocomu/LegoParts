package com.example.albertocomu.legoparts.model;

/**
 * Created by albertocomu on 22/5/17.
 */

public class Part {
    long id;
    int cantidad;
    String name;
    String img;

    public Part(long id, int cantidad, String name, String img) {
        this.id = id;
        this.cantidad = cantidad;
        this.name = name;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

}
