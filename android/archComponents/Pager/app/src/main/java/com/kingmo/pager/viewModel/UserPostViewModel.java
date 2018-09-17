package com.kingmo.pager.viewModel;

import com.kingmo.pager.api.PostServiceManager;
import com.kingmo.pager.database.PostsDao;
import com.kingmo.pager.database.entity.Post;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class UserPostViewModel {
    private PostsDao postsDao;
    private PostServiceManager postServiceManager;
    private PagedList.Config postsPagingConfig;

    public UserPostViewModel(PostsDao postsDao, PostServiceManager postServiceManager) {
        this.postsDao = postsDao;
        this.postServiceManager = postServiceManager;
        this.postsPagingConfig = new PagedList.Config.Builder()
                .setPageSize(50)
                .setPrefetchDistance(150)
                .setEnablePlaceholders(true)
                .build();
    }

    public LiveData<PagedList<Post>> getPostFromDatabase() {
        return new LivePagedListBuilder<>(postsDao.getPostsDataSource(), postsPagingConfig)
                //.setFetchExecutor(myExecutor)
                .build();
    }
}

