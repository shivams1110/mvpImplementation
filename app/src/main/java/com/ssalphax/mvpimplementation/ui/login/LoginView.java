package com.ssalphax.mvpimplementation.ui.login;

public interface LoginView {

    void showProgress();

    void hideProgress();

    void loginSuccess();

    void loginError();

    void onSubmitButtonClick();

    void showToast(String msg);

}
