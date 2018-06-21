package com.ssalphax.mvpimplementation.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContactResponse {

    @SerializedName("contacts")
    private List<Contact> contactList;

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
