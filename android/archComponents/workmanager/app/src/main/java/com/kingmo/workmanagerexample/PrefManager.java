package com.kingmo.workmanagerexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class PrefManager {
    private static final String TAG = PrefManager.class.getSimpleName();
    public static final String MSG_KEY = TAG + ".MSG_KEY";
    private SharedPreferences preferences;

    public PrefManager(Context context) {
        this.preferences = context.getSharedPreferences("MY_PREFS", Context.MODE_PRIVATE);
    }

    @NonNull
    public String getMessage(String msgKey) {
        return preferences.getString(msgKey, "");
    }
}
