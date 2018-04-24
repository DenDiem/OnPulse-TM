package com.diem.den.onpulsetm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisetLink;
    LocalStorage   localStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername =  (EditText) findViewById(R.id.etUsername);
        etPassword =  (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        tvRegisetLink.setOnClickListener(this);
        localStorage = new LocalStorage(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.bLogin:
                User user = new User(null,null);

                localStorage.setUserLoggedIn(true);
                localStorage.storeUser(user);

                break;

            case R.id.tvRegisetLink:
                startActivity(new Intent(this,Register.class));
                break;

        }
    }
}
