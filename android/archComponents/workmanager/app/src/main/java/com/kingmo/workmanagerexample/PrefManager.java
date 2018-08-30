package com.kingmo.workmanagerexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class PrefManager {
    private SharedPreferences preferences;

    public PrefManager(Context context) {
        this.preferences = context.getSharedPreferences("MY_PREFS", Context.MODE_PRIVATE);
    }

    @NonNull
    public String getMessage(String msgKey) {
        return preferences.getString(msgKey, "");
    }
}
