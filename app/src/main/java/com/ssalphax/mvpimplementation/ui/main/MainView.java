package com.ssalphax.mvpimplementation.ui.main;

public interface MainView {

    void showProgress();

    void hideProgress();

    void loginSuccess();

    void loginError();

    void onSubmitButtonClick();

    void showToast(String msg);

}
