package com.diem.den.onpulsetm;

/** create by Denys
 * 23 04 2018
 *
 */
public class User {
    String username,name,secondName,password;
    int age;
    User(String username,String name, String secondName,String password,int age)
    {
        this.name = name;
        this.password = password;
        this.secondName = secondName;
        this.username = username;
        this.age = age;

    }
    User(String username,String password)
    {
        this.name = "";
        this.password = password;
        this.secondName = "";
        this.username = username;
        this.age = -1;

    }
}
