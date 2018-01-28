package com.kingmo.databindingex.scheduler;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kingmo on 1/28/18.
 */
public class TestSchedulerProvider extends SchedulerProvider {


    @Override
    public Scheduler mainThread() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler backgroundThread() {
        return Schedulers.trampoline();
    }
}