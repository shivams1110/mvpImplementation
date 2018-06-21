package com.ssalphax.mvpimplementation.data.rest;

import com.ssalphax.mvpimplementation.data.model.ContactResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("contacts/")
    Call<ContactResponse> getContacts();

}
