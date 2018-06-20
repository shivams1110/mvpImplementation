package com.ssalphax.mvpimplementation.ui.main;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {

        this.mainView = mainView;
    }

    @Override
    public void login(String username, String password) {

        if (username.equals("admin") && password.equals("123")){
            mainView.loginSuccess();
        }else {
            mainView.loginError();
        }


    }
}
