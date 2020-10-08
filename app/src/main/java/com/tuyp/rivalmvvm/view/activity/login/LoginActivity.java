package com.tuyp.rivalmvvm.view.activity.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tuyp.rivalmvvm.MainActivity;
import com.tuyp.rivalmvvm.R;
import com.tuyp.rivalmvvm.config.Pref;
import com.tuyp.rivalmvvm.model.LoginResource;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    TextView btn_register,lupa_password;
    Button btn_login;
    LoginViewModel loginViewModel;
    SharedPreferences sharedPreferences;
    public static final String KEYPREF = "Key Preferences";
    public static final String KEYUSERNAME = "Key Username";
    public static final String KEYPASSWORD = "Key Password";
    public static final String KEYEMAIL = "Key Email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);

        if (loginViewModel.getDataUser() != null){

           loginViewModel.getDataUser().observe(LoginActivity.this, new Observer<LoginResource>() {
               @Override
               public void onChanged(LoginResource loginResource) {
                   Log.e("dataaaaaaaa","masuk observe");
                   Pref.putUser(LoginActivity.this,Pref.USER_SESSION,loginResource);
                   Intent i = new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(i);
                   finish();
               }
           });
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("dataaaaaaaa","login diklik");
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                loginViewModel.login(LoginActivity.this,username,password);
            }
        });
    }
}
