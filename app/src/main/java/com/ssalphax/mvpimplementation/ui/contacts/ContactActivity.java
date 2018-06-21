package com.ssalphax.mvpimplementation.ui.contacts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.ssalphax.mvpimplementation.R;
import com.ssalphax.mvpimplementation.adapter.ContactAdapter;
import com.ssalphax.mvpimplementation.data.model.Contact;

import java.util.List;

public class ContactActivity extends AppCompatActivity implements ContactView{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ContactPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerViewContact);
        progressBar = findViewById(R.id.progressContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new ContactPresenterImpl(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        presenter.loadingContacts();
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showContacts(List<Contact> contactList) {

        ContactAdapter adapter = new ContactAdapter(this, contactList);
        recyclerView.setAdapter(adapter);

    }
}
