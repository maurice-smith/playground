package com.kingmo.databindingex.scheduler;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kingmo on 1/27/18.
 */

public class SchedulerProvider {

    public Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    public Scheduler backgroundThread() {
        return Schedulers.io();
    }

}
