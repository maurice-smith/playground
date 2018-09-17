package com.kingmo.pager;


import android.util.Log;

import com.kingmo.pager.api.models.ApiPost;
import com.kingmo.pager.database.entity.Post;

import java.util.List;

import androidx.paging.PagedList;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.kingmo.pager.PostRepo.NETWORK_PAGE_SIZE;

public class PostBoundaryCallback extends PagedList.BoundaryCallback<Post> {
    private static final String TAG = PostBoundaryCallback.class.getSimpleName();

    private PostRepo postRepo;

    public PostBoundaryCallback(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    /**
     * Database returned 0 items. We should query the backend for more items.
     */
    @Override
    public void onZeroItemsLoaded() {
        int startIndex = 0;
        postRepo.saveLastFetchedStartIndex(startIndex);
        Observable<List<ApiPost>> postObservable = postRepo.getPostsFromApi(startIndex, NETWORK_PAGE_SIZE);
        postObservable.subscribe(getPostApiObserver());
    }

    @Override
    public void onItemAtFrontLoaded(Post itemAtFront) {
        // ignored, since we only ever append to what's in the DB
    }

    /**
     * User reached to the end of the list.
     */
    @Override
    public void onItemAtEndLoaded(Post itemAtEnd) {
        int startIndex = postRepo.getLastFetchedStartIndex() + NETWORK_PAGE_SIZE;
        postRepo.saveLastFetchedStartIndex(startIndex);

        //load more items from API
        Observable<List<ApiPost>> postObservable = postRepo.getPostsFromApi(startIndex, NETWORK_PAGE_SIZE);
        postObservable.subscribe(getPostApiObserver());
    }

    private Observer<List<ApiPost>> getPostApiObserver() {
        return new Observer<List<ApiPost>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<ApiPost> apiPosts) {
                postRepo.saveToDatabase(apiPosts);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "Error fetching Posts from API.", e);
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
