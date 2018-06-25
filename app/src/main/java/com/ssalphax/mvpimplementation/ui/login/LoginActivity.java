package com.ssalphax.mvpimplementation.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ssalphax.mvpimplementation.R;
import com.ssalphax.mvpimplementation.ui.contacts.ContactActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;

    private EditText edtUsername;
    private EditText edtPwd;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUserName);
        edtPwd = findViewById(R.id.edtPwd);
        btnSubmit = findViewById(R.id.btnSubmit);

        presenter = new LoginPresenterImpl(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitButtonClick();
            }
        });


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loginSuccess() {
        start();
        showToast("Login Success");
    }

    private void start() {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginError() {
        showToast("Login Fail");
    }

    @Override
    public void onSubmitButtonClick() {

        String userName = edtUsername.getText().toString().trim();
        String pwd = edtPwd.getText().toString().trim();

        if (TextUtils.isEmpty(userName)){
            showToast("enter username");
            return;
        }

        if (TextUtils.isEmpty(pwd)){
            showToast("enter Password");
            return;
        }

        presenter.login(userName, pwd);


    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
