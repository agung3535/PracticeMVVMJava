package com.tuyp.rivalmvvm.view.activity.login;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.tuyp.rivalmvvm.config.ApiService;
import com.tuyp.rivalmvvm.config.Network;
import com.tuyp.rivalmvvm.model.LoginResource;
import com.tuyp.rivalmvvm.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {

    private ApiService apiService;

    MutableLiveData<LoginResource> loginData = new MutableLiveData<>();

    public void doLogin(Context context,String username, String password){
        apiService = Network.builder(context).create(ApiService.class);
        Call<LoginResponse> call = apiService.login(username,password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("dataaaaa","masuk on response "+response.body());
                if (response.isSuccessful()){
                    Log.e("dataaaaaa","login sukses");
                    loginData.postValue(response.body().getSuccess());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("dataaaaaa",t.getMessage().toString());
            }
        });
    }

}
