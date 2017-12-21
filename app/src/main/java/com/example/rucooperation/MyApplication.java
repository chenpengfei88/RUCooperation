package com.example.rucooperation;

import android.app.Application;

import me.free.rucooperation.RUCooperation;

/**
 * Created by lenovo on 2017/8/17.
 */

public class MyApplication extends Application  {

    @Override
    public void onCreate() {
        super.onCreate();

        RUCooperation.getDefault().init(this);
    }
}
