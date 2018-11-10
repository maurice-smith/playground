package com.kingmo.pager.ui;

import android.content.res.Resources;

import com.kingmo.pager.R;
import com.kingmo.pager.database.entity.Post;

public class PostViewModel {
    private long userId;
    private long id;
    private String title;
    private String body;
    private Resources resources;

    public PostViewModel(Resources resources, Post post) {
        this.userId = post.getUserId();
        this.id = post.getId();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.resources = resources;
    }

    public String getUserIdText() {
        return resources.getString(R.string.post_userId, userId);
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getIdText() {
        return resources.getString(R.string.post_id, id);
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
}
