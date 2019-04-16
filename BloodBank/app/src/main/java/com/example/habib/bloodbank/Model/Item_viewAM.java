package com.example.habib.bloodbank.Model;

public class Item_viewAM {
    int image, image1, image2, image3;
    String ambulance_Name, ambulance_District, ambulance_Location, ambulance_Contact;

    public Item_viewAM(String ambulance_Name, String ambulance_District, String ambulance_Location,
                       String ambulance_Contact, int image, int image1, int image2, int image3) {

        this.ambulance_Name = ambulance_Name;
        this.ambulance_District = ambulance_District;
        this.ambulance_Location = ambulance_Location;
        this.ambulance_Contact = ambulance_Contact;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public String getAmbulance_Name() {
        return ambulance_Name;
    }

    public String getAmbulance_District() {
        return ambulance_District;
    }

    public String getAmbulance_Location() {
        return ambulance_Location;
    }

    public String getAmbulance_Contact() {
        return ambulance_Contact;
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

}
