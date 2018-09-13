package com.kingmo.pager;

import android.app.Application;

import com.kingmo.pager.database.AppDatabase;

public class PagerApplication extends Application {

    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = AppDatabase.getInstance(this);
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
