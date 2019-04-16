package com.example.habib.bloodbank.Model;

public class Item_view {
    private int image, image1, image2, image3, image4, image5, image6, image7;
    private String name, blood, bl_amount, district, contact,
            hospital_name, hospital_loc, description;

    public Item_view(String name, String blood, String bl_amount,
                     String district, String contact, String hospital_name, String hospital_loc,
                     String description, int image, int image1, int image2, int image3, int image4,
                     int image5, int image6, int image7) {

        this.name = name;
        this.blood = blood;
        this.bl_amount = bl_amount;
        this.district = district;
        this.contact = contact;
        this.hospital_name = hospital_name;
        this.hospital_loc = hospital_loc;
        this.description = description;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.image6 = image6;
        this.image7 = image7;
    }

    public int getImage() {
        return image;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public int getImage3() {
        return image3;
    }

    public int getImage4() {
        return image4;
    }

    public int getImage5() {
        return image5;
    }

    public int getImage6() {
        return image6;
    }

    public int getImage7() {
        return image7;
    }

    public String getName() {
        return name;
    }

    public String getBlood() {
        return blood;
    }

    public String getBl_amount() {
        return bl_amount;
    }

    public String getDistrict() {
        return district;
    }

    public String getContact() {
        return contact;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public String getHospital_loc() {
        return hospital_loc;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public void setImage4(int image4) {
        this.image4 = image4;
    }

    public void setImage5(int image5) {
        this.image5 = image5;
    }

    public void setImage6(int image6) {
        this.image6 = image6;
    }

    public void setImage7(int image7) {
        this.image7 = image7;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public void setBl_amount(String bl_amount) {
        this.bl_amount = bl_amount;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public void setHospital_loc(String hospital_loc) {
        this.hospital_loc = hospital_loc;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

