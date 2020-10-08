package com.tuyp.rivalmvvm.config;

import com.tuyp.rivalmvvm.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("username") String username,
                              @Field("password") String password);

}
