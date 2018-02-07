package com.kingmo.roomex.viewmodel;

import android.content.res.Resources;

import com.kingmo.roomex.SchedulerProvider;
import com.kingmo.roomex.database.TeamMate;
import com.kingmo.roomex.repository.TeamMateRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kingmo on 2/4/18.
 */
public class RosterEntryViewModelTest {
    @Mock
    private TeamMateRepository teamMateRepo;

    @Mock
    private SchedulerProvider schedulerProvider;

    @Mock
    private Resources res;

    private RosterEntryViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(schedulerProvider.backgroundThread()).thenReturn(Schedulers.trampoline());
        when(schedulerProvider.mainThread()).thenReturn(Schedulers.trampoline());
    }

    @Test
    public void testGetFormattedTeamInfos() throws Exception {

        List<TeamMate> mates = new ArrayList<>();
        mates.add(new TeamMate(4354, "Billy", 20));
        mates.add(new TeamMate(90394, "Stokes", 15));

        final List<TeamMateViewModel> resultList = new ArrayList<>();

        when(teamMateRepo.getTeamMates()).thenReturn(Flowable.just(mates));

        viewModel = new RosterEntryViewModel(teamMateRepo, schedulerProvider, res);
        viewModel.getFormattedTeamInfos()
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())
                .subscribe(new Consumer<List<TeamMateViewModel>>() {
            @Override
            public void accept(List<TeamMateViewModel> viewModels) throws Exception {
                resultList.addAll(viewModels);
            }
        });

        assertThat(resultList.size(), is(2));
        assertThat(resultList.get(0).toString(), is("TeamMateViewModel{mateId:4354, name:Billy, jerseyNumber:20}"));

        verify(teamMateRepo, times(1)).getTeamMates();
    }
}