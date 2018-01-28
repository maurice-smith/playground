package com.kingmo.databindingex.viewmodel;

import com.kingmo.databindingex.model.Person;
import com.kingmo.databindingex.repo.PersonRepo;
import com.kingmo.databindingex.scheduler.TestSchedulerProvider;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by kingmo on 1/28/18.
 */
public class PersonViewModelTest {

    private PersonViewModel personViewModel;
    private PersonRepo personRepo;
    private Person result;

    @Before
    public void setUp() throws Exception {
        personRepo = mock(PersonRepo.class);
        result = null;
        personViewModel = new PersonViewModel(null, personRepo, new TestSchedulerProvider());
    }

    @Test
    public void testGetDefaultPersonData() throws Exception {
        Observable<Person> observer = Observable.just(new Person(null, 0));
        observer.subscribe(person -> result = person);

        when(personRepo.getPersonInfo()).thenReturn(observer);

        personViewModel.getPersonData();

        assertNotNull(result);
        assertThat(result.toString(), is("Person{name='null', age=0}"));
        verify(personRepo, atLeastOnce()).getPersonInfo();
    }

}