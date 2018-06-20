package com.ssalphax.mvpimplementation.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ssalphax.mvpimplementation.R;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter presenter;

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

        presenter = new MainPresenterImpl(this);

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
        showToast("Login Success");
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