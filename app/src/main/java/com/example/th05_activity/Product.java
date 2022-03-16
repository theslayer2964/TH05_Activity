package com.example.th05_activity;

import java.io.Serializable;

public class Product implements Serializable {
    private int picture;
    private String name;
    private double price;
    private String discription;

    public Product(int picture, String name, double price, String discription) {
        this.picture = picture;
        this.name = name;
        this.price = price;
        this.discription = discription;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
