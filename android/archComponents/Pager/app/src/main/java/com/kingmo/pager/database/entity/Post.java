package com.kingmo.pager.database.entity;


import java.util.Arrays;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts")
public class Post {
    @ColumnInfo(name = "user_id")
    private long userId;

    @PrimaryKey
    @ColumnInfo(name = "post_id")
    private long id;

    private String title;

    private String body;

    public Post(long userId, long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{id, userId, title, body});
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Post) {
            Post param = (Post) obj;

            return userId == param.userId
                    && id == param.getId()
                    && title.equals(param.title)
                    && body.equals(param.body);
        }
        return false;
    }
}
