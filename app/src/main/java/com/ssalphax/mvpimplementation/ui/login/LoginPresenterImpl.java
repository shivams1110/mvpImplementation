package com.ssalphax.mvpimplementation.ui.login;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {

        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {

        if (username.equals("admin") && password.equals("123")){
            loginView.loginSuccess();
        }else {
            loginView.loginError();
        }


    }
}
