package com.kingmo.roomex;

import android.app.Application;

import com.kingmo.roomex.database.AppDatabase;

/**
 * Created by kingmo on 1/31/18.
 */

public class RoomExApplication extends Application {

    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = AppDatabase.getAppDatabase(this);

    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
