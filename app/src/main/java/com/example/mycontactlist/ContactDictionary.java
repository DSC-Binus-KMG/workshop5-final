package com.example.mycontactlist;

import android.content.Context;

import java.util.ArrayList;

public class ContactDictionary {

    private static ContactDictionary contactDictionary;
    private ArrayList<Contact> contacts;

    public static ContactDictionary getInstance() {
        if (contactDictionary == null)
            contactDictionary = new ContactDictionary();
        return contactDictionary;
    }

    private ContactDictionary() {
        generateContactData();
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    private void generateContactData() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Anggi Maisa", "08212488****", true));
        contacts.add(new Contact("Fernando Christyanto", "0856123****", true));
        contacts.add(new Contact("Jonathan Darwin", "08136248****", false));
        contacts.add(new Contact("Naufal Prakoso", "08963213****", false));
        contacts.add(new Contact("Willson", "08963852****", true));
    }

}
