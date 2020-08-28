package com.glg.easyloading;

import android.app.Application;

import com.glg.easyloading.lib.EasyLoading;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EasyLoading.getInstance().init(this);
    }
}
