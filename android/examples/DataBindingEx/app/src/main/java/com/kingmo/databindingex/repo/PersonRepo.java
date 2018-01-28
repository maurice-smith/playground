package com.kingmo.databindingex.repo;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.kingmo.databindingex.model.Person;
import com.kingmo.databindingex.scheduler.SchedulerProvider;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by kingmo on 1/27/18.
 */

public class PersonRepo {
    private Person person = new Person("", 0);

    public PersonRepo() {
    }

    @NonNull
    public Observable<Person> getPersonInfo() {

        return Observable.create(emitter -> {
            //simulate long running task
            SystemClock.sleep(1000);

            emitter.onNext(person);
            emitter.onComplete();
        });
    }

    @NonNull
    public Observable<Person> updatePerson(Person p) {
        person = p;

        return Observable.create(emitter -> {
            //simulate long running task
            SystemClock.sleep(1000);

            emitter.onNext(person);
            emitter.onComplete();
        });
    }
}
