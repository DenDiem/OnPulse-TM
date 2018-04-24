package com.diem.den.onpulsetm;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *Created by Denys Baranov inc on 23.04.2018.
 */
public class LocalStorage {
    public static final String SP_NAME ="userDetails";
    SharedPreferences userLocalDatabase;

    LocalStorage(Context context)
    {
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUser(User user)
    {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name",user.name);
        spEditor.putString("secondName",user.secondName);
        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);
        spEditor.putInt("age",user.age);
        spEditor.commit();

    }
    public User getLoggedInUser()
    {
        String name = userLocalDatabase.getString("name","");
        String secondName = userLocalDatabase.getString("secondName","");
        String username = userLocalDatabase.getString("username","");
        String password = userLocalDatabase.getString("password","");
        int age = userLocalDatabase.getInt("age",-1);
        return new User(username,name,secondName,password,age);
    }
    public void setUserLoggedIn(boolean loggedIn)
    {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }

    public void clear(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
    public boolean getUserLoggedIn()
    {
       return userLocalDatabase.getBoolean("loggedIn",false);
    }
}
