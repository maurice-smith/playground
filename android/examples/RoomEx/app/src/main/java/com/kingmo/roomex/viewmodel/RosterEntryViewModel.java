package com.kingmo.roomex.viewmodel;

import android.content.res.Resources;

import com.kingmo.roomex.SchedulerProvider;
import com.kingmo.roomex.database.TeamMate;
import com.kingmo.roomex.repository.TeamMateRepository;
import com.kingmo.roomex.view.TeamMateClickHandler;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;

/**
 * Created by kingmo on 1/31/18.
 */

public class RosterEntryViewModel {
    private TeamMateRepository teamMateRepo;
    private SchedulerProvider schedulerProvider;
    private String mateNameEntry;
    private int jerseyNumberEntry;
    private Resources res;
    private boolean isNoResultsVisible;
    private boolean isPlayerResultsVisible;
    private TeamMateClickHandler mateClickHandler;

    public RosterEntryViewModel(TeamMateRepository teamMateRepo,
                                SchedulerProvider schedulerProvider,
                                Resources res,
                                TeamMateClickHandler mateClickHandler) {
        this.teamMateRepo = teamMateRepo;
        this.schedulerProvider = schedulerProvider;
        this.res = res;
        this.mateClickHandler = mateClickHandler;
    }

    public Flowable<List<TeamMateViewModel>> getFormattedTeamInfos() {
        return teamMateRepo.getTeamMates()
                .observeOn(schedulerProvider.mainThread())
                .subscribeOn(schedulerProvider.backgroundThread())
                .map(new Function<List<TeamMate>, List<TeamMateViewModel>>() {
                    @Override
                    public List<TeamMateViewModel> apply(List<TeamMate> teamMates) throws Exception {
                        return getTeamMates(teamMates);
                    }
                });
    }

    public Completable addTeamMate(final String name, final int jerseyNum) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                teamMateRepo.addTeamMate(new TeamMate(name, jerseyNum));
            }
        }).observeOn(schedulerProvider.mainThread())
                .subscribeOn(schedulerProvider.backgroundThread());
    }

    public Completable removeTeamMate (final TeamMate mate) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                teamMateRepo.removeMate(mate);
            }
        }).observeOn(schedulerProvider.mainThread())
                .subscribeOn(schedulerProvider.backgroundThread());
    }

    public String getMateNameEntry() {
        return mateNameEntry;
    }

    public void setMateNameEntry(String mateNameEntry) {
        this.mateNameEntry = mateNameEntry;
    }

    public int getJerseyNumberEntry() {
        return jerseyNumberEntry;
    }

    public void setJerseyNumberEntry(int jerseyNumberEntry) {
        this.jerseyNumberEntry = jerseyNumberEntry;
    }

    public boolean isNoResultsVisible() {
        return isNoResultsVisible;
    }

    public void setNoResultsVisible(boolean noResultsVisible) {
        isNoResultsVisible = noResultsVisible;
    }

    public boolean isPlayerResultsVisible() {
        return isPlayerResultsVisible;
    }

    public void setPlayerResultsVisible(boolean playerResultsVisible) {
        isPlayerResultsVisible = playerResultsVisible;
    }

    private List<TeamMateViewModel> getTeamMates(List<TeamMate> teamMates) {
        List<TeamMateViewModel> formattedMates = new ArrayList<>();
        for (TeamMate mate : teamMates) {
            formattedMates.add(new TeamMateViewModel(res, mate,
                    mateClickHandler));
        }

        setNoResultsVisible(formattedMates.isEmpty());
        setPlayerResultsVisible(!formattedMates.isEmpty());

        return formattedMates;
    }
}
