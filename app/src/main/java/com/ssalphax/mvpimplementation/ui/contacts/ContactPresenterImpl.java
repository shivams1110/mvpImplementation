package com.ssalphax.mvpimplementation.ui.contacts;

import com.ssalphax.mvpimplementation.data.model.Contact;
import com.ssalphax.mvpimplementation.data.model.ContactResponse;
import com.ssalphax.mvpimplementation.data.rest.ApiClient;
import com.ssalphax.mvpimplementation.data.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactPresenterImpl implements ContactPresenter {

    private ContactView contactView;
    List<Contact> contacts = new ArrayList<>();
    public ContactPresenterImpl(ContactView contactView) {
        this.contactView = contactView;
    }

    @Override
    public void loadingContacts() {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ContactResponse> call = apiService.getContacts();

        call.enqueue(new Callback<ContactResponse>() {
            @Override
            public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {


                contacts = response.body().getContactList();
                contactView.hideProgress();
                contactView.showContacts(contacts);

            }

            @Override
            public void onFailure(Call<ContactResponse> call, Throwable t) {

            }
        });

    }
}
