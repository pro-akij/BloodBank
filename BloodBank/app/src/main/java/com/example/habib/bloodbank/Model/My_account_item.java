package com.example.habib.bloodbank.Model;

public class My_account_item {
    int image, image1, image2, image3;
    String my_Name, my_Contact, my_blood, my_district;

    public My_account_item(String my_Name, String my_Contact, String my_blood, String my_district,
                           int image, int image1, int image2, int image3) {

        this.my_Name = my_Name;
        this.my_Contact = my_Contact;
        this.my_blood = my_blood;
        this.my_district = my_district;
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

    public String getMy_Name() {
        return my_Name;
    }

    public String getMy_Contact() {
        return my_Contact;
    }

    public String getMy_blood() {
        return my_blood;
    }

    public String getMy_district() {
        return my_district;
    }
}
