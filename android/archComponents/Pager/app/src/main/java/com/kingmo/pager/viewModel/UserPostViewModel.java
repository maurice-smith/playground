package com.kingmo.pager.viewModel;

import com.kingmo.pager.PostBoundaryCallback;
import com.kingmo.pager.PostRepo;
import com.kingmo.pager.database.entity.Post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import static com.kingmo.pager.PostRepo.NETWORK_PAGE_SIZE;

public class UserPostViewModel extends ViewModel {
    private PostRepo postRepo;
    private PagedList.Config postsPagingConfig;

    public UserPostViewModel() {
        this.postsPagingConfig = new PagedList.Config.Builder()
                .setPageSize(NETWORK_PAGE_SIZE)
                .setPrefetchDistance(NETWORK_PAGE_SIZE)
                .setEnablePlaceholders(true)
                .build();
    }

    public void setPostRepo(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public UserPostViewModel(PostRepo postRepo) {
        this.postRepo = postRepo;
        this.postsPagingConfig = new PagedList.Config.Builder()
                .setPageSize(NETWORK_PAGE_SIZE)
                .setPrefetchDistance(NETWORK_PAGE_SIZE)
                .setEnablePlaceholders(true)
                .build();
    }

    public LiveData<PagedList<Post>> getPostData() {
        return new LivePagedListBuilder<>(postRepo.getPostsDataSource(), postsPagingConfig)
                .setBoundaryCallback(new PostBoundaryCallback(postRepo))
                //.setFetchExecutor(myExecutor)
                .build();
    }
}

