package com.example.olijefavour.myapplication;

import android.support.annotation.NonNull;

/**
 * Created by Olije favour on 3/14/2018.
 */

public class UserId {
    public  String userId;

    public <T extends UserId> T withId(@NonNull final String id){
        this.userId=id;
        return (T)this;
    }
}
