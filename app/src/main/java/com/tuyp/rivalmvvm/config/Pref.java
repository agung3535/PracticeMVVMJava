package com.tuyp.rivalmvvm.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tuyp.rivalmvvm.model.LoginResource;

import java.lang.reflect.Type;
import java.util.List;

public class Pref {
    public static final String USER_SESSION = "user_session";

    public static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void putUser(Context context, String key, LoginResource user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        putString(context, key, json);
    }

//    public static void putKecamatan(Context context, String key, List<KecamatanModel> kecamatanModel){
//        Gson gson = new Gson();
//        String json = gson.toJson(kecamatanModel);
//        putString(context,key,json);
//    }
//
//    public static List<KecamatanModel> getKecamatan(Context context, String key){
//        Gson gson = new Gson();
//        String json = getString(context,key);
//        Type type = new TypeToken<List<KecamatanModel>>() {}.getType();
//        return gson.fromJson(json, type);
//    }


    public static LoginResource getUser(Context context, String key) {
        Gson gson = new Gson();
        String json = getString(context, key);
        LoginResource user = gson.fromJson(json, LoginResource.class);
        return user;
    }

    public static void putString(Context context, String key, String value) {
        getSharedPreference(context).edit().putString(key, value).apply();
    }

    public static String getString(Context context, String key) {
        return getSharedPreference(context).getString(key, null);
    }

    public static void clear(Context context) {
        getSharedPreference(context).edit().clear().apply();
    }
}
