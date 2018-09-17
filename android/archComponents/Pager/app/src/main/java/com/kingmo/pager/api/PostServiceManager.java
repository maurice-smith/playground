package com.kingmo.pager.api;

import com.kingmo.pager.api.models.ApiPost;
import com.kingmo.pager.api.services.PostApiService;

import java.util.List;

import io.reactivex.Observable;

public class PostServiceManager {
    private PostApiService postApiService;

    public PostServiceManager(PostApiService postApiService) {
        this.postApiService = postApiService;
    }

    public Observable<List<ApiPost>> getPosts(int startIndex, int resultLimit) {
        return postApiService.getPosts(startIndex, resultLimit);
    }
}
