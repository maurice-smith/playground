package com.kingmo.pager.api.services;

import com.kingmo.pager.api.models.ApiPost;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostApiService {
    @GET("posts")
    Observable<List<ApiPost>> getPosts(@Query("_start") int startIndex, @Query("_limit") int limit);
}
