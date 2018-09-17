package com.kingmo.pager;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String PREF_NAME = "PAGER_APP_PREFS";
    private SharedPreferences preferences;

    public SharedPrefManager(Context context) {
        this.preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void save(String key, String value) {
        preferences.edit().putString(key, value).commit();
    }

    public void save(String key, int value) {
        preferences.edit().putInt(key, value).commit();
    }

    public String getStringValue(String key) {
        return preferences.getString(key, "");
    }

    public int getIntValue(String key) {
        return preferences.getInt(key, -1);
    }

    public void remove(String key) {
        preferences.edit().remove(key).commit();
    }
}
