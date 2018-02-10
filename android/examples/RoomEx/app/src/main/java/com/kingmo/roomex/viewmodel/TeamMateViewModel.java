package com.kingmo.roomex.viewmodel;

import android.content.res.Resources;

import com.kingmo.roomex.R;
import com.kingmo.roomex.database.TeamMate;
import com.kingmo.roomex.view.TeamMateClickHandler;

/**
 * Created by kingmo on 2/1/18.
 */

public class TeamMateViewModel {
    private TeamMate mate;
    private Resources res;
    private TeamMateClickHandler teamMateClickHandler;

    public TeamMateViewModel(Resources res, TeamMate mate,
                             TeamMateClickHandler teamMateClickHandler) {
        this.mate = mate;
        this.res = res;
        this.teamMateClickHandler = teamMateClickHandler;
    }

    public String getMateNameText() {
        return res.getString(R.string.info_txt_format, mate.getId(),
                mate.getName(), mate.getJerseyNumber());
    }

    public void infoRowClick() {
        teamMateClickHandler.removeMateClick(mate);
    }

    @Override
    public String toString() {
        return "TeamMateViewModel{" +
                "mateId:" + mate.getId() +
                ", name:" + mate.getName() +
                ", jerseyNumber:" + mate.getJerseyNumber() +
                '}';
    }
}
