package com.example.mycontactlist;

public class Contact {

    String name;
    String phoneNumber;
    boolean favorite;

    public Contact(String name, String phoneNumber, boolean favorite) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
