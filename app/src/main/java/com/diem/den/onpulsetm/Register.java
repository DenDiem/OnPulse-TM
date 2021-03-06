package com.diem.den.onpulsetm;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity  {
    /*Button bRegister;
    etUsername, etPassword, etName, etSecondName,etAge;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etUsername =  (EditText) findViewById(R.id.etUsername);
        final EditText etPassword =  (EditText) findViewById(R.id.etPassword);
        final EditText etName =  (EditText) findViewById(R.id.etName);
        final EditText etSecondName =  (EditText) findViewById(R.id.etSecondName);
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final Button  bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String username =etUsername.getText().toString();
                final String name =etName.getText().toString();
                final String secondName =etSecondName.getText().toString();
                final String password =etPassword.getText().toString();
                final int age =Integer.parseInt(etAge.getText().toString());

                Response.Listener<String> stringListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(Register.this,Login.class);
                                Register.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("Regiser fail").setNegativeButton("Retry",null).create().show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name,secondName,age,username,password,stringListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);
            }
        });
    }

  /*  @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bRegister:
                String username =etUsername.getText().toString();
                String name =etName.getText().toString();
                String secondName =etSecondName.getText().toString();
                String password =etPassword.getText().toString();
                int age =Integer.parseInt(etAge.getText().toString());
                User dateUser = new User(username,name,secondName,password,age);
                break;

        }
    }*/
}
