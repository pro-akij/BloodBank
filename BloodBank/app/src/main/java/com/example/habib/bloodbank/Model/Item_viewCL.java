package com.example.habib.bloodbank.Model;

public class Item_viewCL {
    int image, image1, image2, image3;
    String club_Name, club_location, club_district, club_Contact;

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

    public String getClub_Name() {
        return club_Name;
    }

    public String getClub_location() {
        return club_location;
    }

    public String getClub_district() {
        return club_district;
    }

    public String getClub_Contact() {
        return club_Contact;
    }

    public Item_viewCL(String club_Name, String club_location, String club_district, String club_Contact,
                       int image, int image1, int image2, int image3) {

        this.club_Name = club_Name;
        this.club_location = club_location;
        this.club_district = club_district;
        this.club_Contact = club_Contact;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;


    }
}
