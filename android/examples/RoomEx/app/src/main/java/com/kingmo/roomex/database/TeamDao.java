package com.kingmo.roomex.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by kingmo on 1/30/18.
 */

@Dao
public interface TeamDao {

    @Query(value = "SELECT * FROM team_mates WHERE id = :id LIMIT 1")
    Flowable<TeamMate> findTeamMateById(String id);

    @Query(value = "SELECT * FROM team_mates")
    Flowable<List<TeamMate>> getTeamMates();

    @Insert
    void add(TeamMate... mates);

    @Update
    void update(TeamMate mate);

    @Delete
    void delete(TeamMate... mates);
}
