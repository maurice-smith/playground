package com.kingmo.roomex.repository;

import com.kingmo.roomex.database.TeamDao;
import com.kingmo.roomex.database.TeamMate;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by kingmo on 2/1/18.
 */

public class TeamMateRepository {
    private TeamDao teamDao;

    public TeamMateRepository(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public Flowable<TeamMate> getTeamMate(long id) {
        return teamDao.findTeamMateById(id);
    }

    public Flowable<List<TeamMate>> getTeamMates() {
        return teamDao.getTeamMates();
    }

    public void addTeamMate(TeamMate mate) {
        teamDao.add(mate);
    }

    public void update(TeamMate mate) {
        teamDao.update(mate);
    }

    public void removeMate(TeamMate mate) {
        teamDao.delete(mate);
    }
}
