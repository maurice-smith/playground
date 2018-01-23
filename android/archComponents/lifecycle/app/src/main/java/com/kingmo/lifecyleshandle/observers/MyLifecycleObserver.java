package com.kingmo.lifecyleshandle.observers;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.kingmo.lifecyleshandle.LifeCycleCallback;

public class MyLifecycleObserver implements LifecycleObserver {

    private LifeCycleCallback callback;

    public MyLifecycleObserver(LifeCycleCallback callback) {
        this.callback = callback;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create() {
        callback.doStuff(Lifecycle.Event.ON_CREATE.name());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        callback.doStuff(Lifecycle.Event.ON_START.name());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        callback.doStuff(Lifecycle.Event.ON_STOP.name());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume() {
        callback.doStuff(Lifecycle.Event.ON_RESUME.name());
    }
}
