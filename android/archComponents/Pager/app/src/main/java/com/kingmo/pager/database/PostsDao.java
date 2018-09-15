package com.kingmo.pager.database;

import com.kingmo.pager.database.entity.Post;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Flowable;

@Dao
public interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Post... posts);

    @Delete
    void delete(Post... posts);

    @Query("DELETE FROM posts")
    void deleteAll();

    @Query("SELECT * FROM posts LIMIT x = :numToReturn,y = :offset")
    Flowable<List<Post>> getPosts(int numToReturn, int offset);

    @Query("SELECT * FROM post WHERE id = :postId LIMIT 1")
    Flowable<Post> getPost(int postId);
}
