package com.kingmo.databindingex.viewmodel;

import android.support.annotation.NonNull;
import android.support.v4.math.MathUtils;
import android.text.TextUtils;

import com.kingmo.databindingex.repo.PersonRepo;
import com.kingmo.databindingex.model.Person;
import com.kingmo.databindingex.scheduler.SchedulerProvider;

//import io.reactivex.Observable;
import org.apache.commons.lang3.StringUtils;

import java.util.Observable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Created by kingmo on 1/27/18.
 */

public class PersonViewModel extends Observable {

    private Person person;
    private SchedulerProvider schedulerProvider;
    private PersonRepo repo;
    private CompositeDisposable subscribers = new CompositeDisposable();

    public PersonViewModel(Person person, PersonRepo repo, SchedulerProvider schedulerProvider) {
        this.person = person;
        this.schedulerProvider = schedulerProvider;
        this.repo = repo;
    }

    private void unregisterSubscribers() {
        if (subscribers != null && !subscribers.isDisposed()) {
            subscribers.dispose();
        }
    }

    @NonNull
    public String getPersonInfo() {
        String personInfo = "No Person info.";

        if (person != null) {
            personInfo = person.getName() + " is " + person.getAge() + " years old.";
        }

        return personInfo;
    }

    public void updatePersonData(String name, String age) {
        if (StringUtils.isBlank(name)) {
            name = "Default Person Name.";
        }

        if (!StringUtils.isNumeric(age)) {
            age = "0";
        }

        Disposable updateDataSubscriber = repo.updatePerson(new Person(name, Integer.valueOf(age)))
                .subscribeOn(schedulerProvider.backgroundThread())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(this::updateObservers);
        subscribers.add(updateDataSubscriber);
    }

    public void getPersonData() {
        Disposable getDataSubscriber = repo.getPersonInfo()
                .subscribeOn(schedulerProvider.backgroundThread())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(this::updateObservers);

        subscribers.add(getDataSubscriber);
    }

    private void updateObservers(Person updatedPerson) {
        person = updatedPerson;
        setChanged();
        notifyObservers();
    }

    public void cleanUp() {
        unregisterSubscribers();
        subscribers = null;
    }
}