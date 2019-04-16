package com.example.habibadnan.e_commerce;

import android.media.Image;

public class Model {
    public Model(){

    }
    private String imageuri, details, prize, quantity;
    public Model(String imageuri, String details, String prize, String quantity){
        this.details= details;
        this.prize= prize;
        this.quantity= quantity;
        this.imageuri= imageuri;
    }

    public String getDetails() {
        return details;
    }

    public String getPrize() {
        return prize;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getImageuri() {
        return imageuri;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setImageuri(String imageuri) {
        this.imageuri = imageuri;
    }
}
