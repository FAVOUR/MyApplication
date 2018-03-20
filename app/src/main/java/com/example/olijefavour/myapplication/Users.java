package com.example.olijefavour.myapplication;

/**
 * Created by Olije favour on 3/11/2018.
 */

public class Users extends UserId {

    String name;

    public Users(){
        this.name=name;
    }
    public Users(String name){
       this.name=name;
    }

    public String getName(){
       return this.name;
    }
    public String setName(){
        return this.name=name;
    }
}
