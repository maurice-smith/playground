package com.kingmo.pager.database;

import com.kingmo.pager.database.entity.Post;

import java.util.List;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Flowable;

@Dao
public interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(List<Post> posts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Post... posts);

    @Delete
    void delete(Post... posts);

    @Query("DELETE FROM posts")
    void deleteAll();

    @Query("SELECT * FROM posts")
    Flowable<List<Post>> getPosts();

    @Query("SELECT * FROM posts WHERE post_id = :postId LIMIT 1")
    Flowable<Post> getPost(int postId);

    // The Integer type parameter tells Room to use a PositionalDataSource
    // object, with position-based loading under the hood.
    @Query("SELECT * FROM posts")
    DataSource.Factory<Integer, Post> getPostsDataSource();
}
