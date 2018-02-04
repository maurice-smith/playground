package com.kingmo.roomex.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Team mate db table
 *
 * Created by kingmo on 1/30/18.
 */
@Entity(tableName = "team_mates")
public class TeamMate {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;

    @ColumnInfo(name = "jersey_number")
    private int jerseyNumber;

    public TeamMate(String name, int jerseyNumber) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    @Ignore
    public TeamMate(long id, String name, int jerseyNumber) {
        this.id = id;
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
}
