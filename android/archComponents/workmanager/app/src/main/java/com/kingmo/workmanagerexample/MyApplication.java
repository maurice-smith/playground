package com.kingmo.workmanagerexample;

import android.app.Application;

import androidx.work.WorkManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //WorkManager.initialize(this, );
    }
}
