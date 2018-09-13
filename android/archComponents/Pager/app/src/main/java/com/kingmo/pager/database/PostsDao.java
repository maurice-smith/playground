package com.kingmo.pager.database;

import com.kingmo.pager.database.entity.Post;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface PostsDao {
    @Insert
    void add(Post... mates);

    @Delete
    void delete(Post... mates);
}
