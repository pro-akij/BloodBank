package com.example.habib.bloodbank.Model;

public class Firebase_sign_data {
    String name, contact, blood, district;

    public Firebase_sign_data(String name, String contact, String blood, String district) {
        this.name = name;
        this.contact = contact;
        this.blood = blood;
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getBlood() {
        return blood;
    }

    public String getDistrict() {
        return district;
    }
}
