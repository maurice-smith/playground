package com.kingmo.workmanagerexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.res.Resources;

import static com.kingmo.workmanagerexample.models.Message.MSG_KEY;

public class SchedulerViewModel extends ViewModel {
    private MutableLiveData<String> sharedPrefMessage;

    public SchedulerViewModel() {
        this.sharedPrefMessage = new MutableLiveData<>();
    }

    public LiveData<String> getSharedPrefMessage(PrefManager prefManager, Resources res) {
        loadMessageFromLastRunJob(prefManager, res);
        return sharedPrefMessage;
    }

    private void loadMessageFromLastRunJob(PrefManager prefManager, Resources res) {
        String prefMsg = prefManager.getMessage(MSG_KEY);
        if (prefMsg.equals("")) {
            prefMsg = "No message from last job run";
        }
        sharedPrefMessage.setValue(res.getString(R.string.lastScheduledMsg, prefMsg));
    }
}
