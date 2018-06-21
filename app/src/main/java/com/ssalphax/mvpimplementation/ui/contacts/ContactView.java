package com.ssalphax.mvpimplementation.ui.contacts;

import com.ssalphax.mvpimplementation.data.model.Contact;

import java.util.List;

public interface ContactView {

    void hideProgress();

    void showContacts(List<Contact> contactList);


}
