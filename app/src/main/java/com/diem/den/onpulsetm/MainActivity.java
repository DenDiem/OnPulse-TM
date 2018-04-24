package com.diem.den.onpulsetm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bLogout;
    EditText etUsername, etName, etSecondName, etAge;
    LocalStorage localStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etName = (EditText) findViewById(R.id.etName);
        etSecondName = (EditText) findViewById(R.id.etSecondName);
        etAge = (EditText) findViewById(R.id.etAge);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        localStorage = new LocalStorage(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(authenticate())
           displayUser();
    }
    private void displayUser(){
        User user  = localStorage.getLoggedInUser();
        etUsername.setText(user.username);
        etName.setText(user.name);
        etSecondName.setText(user.secondName);
        etAge.setText(user.age);

    }
    private boolean authenticate()
    {
        return localStorage.getUserLoggedIn();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogout:
                localStorage.clear();
                localStorage.setUserLoggedIn(false);
                startActivity(new Intent(this, Register.class));
                break;

        }
    }
}
