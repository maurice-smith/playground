package com.kingmo.workmanagerexample.work;

import android.support.annotation.NonNull;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Worker;

public class WorkRequestBuilder {
    private OneTimeWorkRequest.Builder oneTimeBuilder;
    private Class<? extends Worker> workerClass;

    public WorkRequestBuilder(@NonNull Class<? extends Worker> workerClass) {
        this.oneTimeBuilder = new OneTimeWorkRequest.Builder(workerClass);
        this.workerClass = workerClass;
    }

    public WorkRequestBuilder setDelay(long delayInMinutes) {
        oneTimeBuilder.setInitialDelay(delayInMinutes, TimeUnit.MINUTES);
        return this;
    }

    public WorkRequestBuilder setInputData(Map<String, Object> inputDataMap) {
        if (inputDataMap != null && !inputDataMap.isEmpty()) {
            Data.Builder dataBuilder = new Data.Builder().putAll(inputDataMap);
            oneTimeBuilder.setInputData(dataBuilder.build());
        }
        return this;
    }

    public WorkRequestBuilder setWorkTag(@NonNull String tag) {
        oneTimeBuilder.addTag(tag);
        return this;
    }

    public OneTimeWorkRequest build() {
        return oneTimeBuilder.build();
    }

    public Class<? extends Worker> getWorkerClass() {
        return workerClass;
    }
}
