package com.example.administrator.llab.Dagger2;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
public class User {

    String name,pass;

    User(String name,String pass)
    {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "name:"+ getName() + "\n"+"password:"+ getPass() + "\n";
    }
}
