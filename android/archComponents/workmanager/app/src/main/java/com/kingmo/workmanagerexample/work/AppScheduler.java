package com.kingmo.workmanagerexample.work;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class AppScheduler {
    private static final String TAG = AppScheduler.class.getSimpleName();

    private WorkManager workManager;

    public AppScheduler() {
        this.workManager = WorkManager.getInstance();
    }

    public void schedule(WorkRequestBuilder workRequestBuilder) {
        workManager.enqueue(workRequestBuilder.build());
        Log.d(TAG, String.format("%s- scheduled.", workRequestBuilder.getWorkerClass().getSimpleName()));
    }

    public void cancelByTag(@NonNull String tag) {
        workManager.cancelAllWorkByTag(tag);
    }

    public void cancelAllJobs() {
        workManager.cancelAllWork();
    }

    public LiveData<List<WorkStatus>> getWorkStatusesByTag(@NonNull String tag) {
        return workManager.getStatusesByTag(tag);
    }
}
