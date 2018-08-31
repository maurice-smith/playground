package com.kingmo.workmanagerexample.work;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;

import static androidx.work.Worker.Result.SUCCESS;
import static com.kingmo.workmanagerexample.PrefManager.MSG_KEY;

public class SharedPrefWorker extends Worker {
    public static final String TAG = SharedPrefWorker.class.getSimpleName();
    public static final String WORK_EXTRA = TAG + ".WORK_EXTRA";

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "Starting work...");
        Data data = getInputData();

        SharedPreferences sharedPreferences = getApplicationContext()
                .getSharedPreferences("MY_PREFS", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MSG_KEY, data.getString(WORK_EXTRA));
        editor.apply();

        Log.d(TAG, "Work done. Success.");
        return SUCCESS;
    }
}
