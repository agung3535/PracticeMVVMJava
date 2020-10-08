package com.tuyp.rivalmvvm.view.activity.login;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tuyp.rivalmvvm.model.LoginResource;

public class LoginViewModel extends ViewModel {


    LoginRepo loginRepo = new LoginRepo();
    public void login(Context context,String username, String password){
        Log.e("dataaaaa","masuk viewnodel login");
        loginRepo.doLogin(context,username,password);
    }

    public MutableLiveData<LoginResource> getDataUser(){
        return loginRepo.loginData;
    }


}
