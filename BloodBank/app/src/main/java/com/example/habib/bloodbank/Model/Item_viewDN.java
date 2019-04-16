package com.example.habib.bloodbank.Model;

public class Item_viewDN {

    int image, image1, image2, image3;
    String doner_Name, doner_blood_type, doner_district, doner_Contact;

    public Item_viewDN(String doner_Name, String doner_blood_type, String doner_district,
                       String doner_Contact, int image, int image1, int image2, int image3) {

        this.doner_Name = doner_Name;
        this.doner_blood_type = doner_blood_type;
        this.doner_district = doner_district;
        this.doner_Contact = doner_Contact;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
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

    public String getDoner_Name() {
        return doner_Name;
    }

    public String getDoner_blood_type() {
        return doner_blood_type;
    }

    public String getDoner_district() {
        return doner_district;
    }

    public String getDoner_Contact() {
        return doner_Contact;
    }
}
