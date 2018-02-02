package com.kingmo.roomex.viewmodel;

import android.content.res.Resources;

import com.kingmo.roomex.SchedulerProvider;
import com.kingmo.roomex.database.TeamMate;
import com.kingmo.roomex.repository.TeamMateRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
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

    public RosterEntryViewModel(TeamMateRepository teamMateRepo,
                                SchedulerProvider schedulerProvider, Resources res) {
        this.teamMateRepo = teamMateRepo;
        this.schedulerProvider = schedulerProvider;
        this.res = res;
    }

    public Flowable<List<TeamMateViewModel>> getFormattedTeamInfos() {
        return teamMateRepo.getTeamMates()
                .observeOn(schedulerProvider.mainThread())
                .subscribeOn(schedulerProvider.mainThread())
                .map(new Function<List<TeamMate>, List<TeamMateViewModel>>() {
                    @Override
                    public List<TeamMateViewModel> apply(List<TeamMate> teamMates) throws Exception {
                        return getTeamMates(teamMates);
                    }
                });
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

    private List<TeamMateViewModel> getTeamMates(List<TeamMate> teamMates) {
        List<TeamMateViewModel> formattedMates = new ArrayList<>();
        for (TeamMate mate : teamMates) {
            formattedMates.add(new TeamMateViewModel(res, mate.getId(), mate.getName(),
                    mate.getJerseyNumber()));
        }
        return formattedMates;
    }
}
