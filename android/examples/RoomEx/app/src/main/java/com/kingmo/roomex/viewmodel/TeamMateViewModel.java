package com.kingmo.roomex.viewmodel;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.kingmo.roomex.R;
import com.kingmo.roomex.database.TeamMate;

/**
 * Created by kingmo on 2/1/18.
 */

public class TeamMateViewModel {
    private long mateId;
    private String name;
    private int jerseyNumber;
    private Resources res;

    public TeamMateViewModel(Resources res,long mateId, String name, int jerseyNumber) {
        this.mateId = mateId;
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.res = res;
    }

    public String getMateNameText() {
        return res.getString(R.string.info_txt_format, mateId, name, jerseyNumber);
    }

    public void infoRowClick() {
        //Toast.makeText(view.getContext(), "Test Message CLick!!", Toast.LENGTH_SHORT).show();
        System.out.println(this.toString());
        //TODO interface for deletion
    }

    @Override
    public String toString() {
        return "TeamMateViewModel{" +
                "mateId:" + mateId +
                ", name:" + name +
                ", jerseyNumber:" + jerseyNumber +
                '}';
    }
}
