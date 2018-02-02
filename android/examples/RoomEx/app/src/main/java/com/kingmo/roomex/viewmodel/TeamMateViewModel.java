package com.kingmo.roomex.viewmodel;

import android.content.res.Resources;

import com.kingmo.roomex.R;

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
}
