package com.tuyp.rivalmvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("success")
    @Expose
    private LoginResource success;

    @SerializedName("error")
    @Expose
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LoginResource getSuccess() {
        return success;
    }

    public void setSuccess(LoginResource success) {
        this.success = success;
    }
}
