package com.kingmo.roomex;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kingmo on 2/1/18.
 */

public class SchedulerProvider {

    public Scheduler backgroundThread() {
        return Schedulers.io();
    }

    public Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }
}
