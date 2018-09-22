package com.kingmo.pager.viewModel;

import com.kingmo.pager.api.PostServiceManager;
import com.kingmo.pager.database.PostsDao;
import com.kingmo.pager.database.entity.Post;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import static com.kingmo.pager.PostRepo.NETWORK_PAGE_SIZE;

public class UserPostViewModel {
    private PostsDao postsDao;
    private PostServiceManager postServiceManager;
    private PagedList.Config postsPagingConfig;

    public UserPostViewModel(PostsDao postsDao, PostServiceManager postServiceManager) {
        this.postsDao = postsDao;
        this.postServiceManager = postServiceManager;
        this.postsPagingConfig = new PagedList.Config.Builder()
                .setPageSize(NETWORK_PAGE_SIZE)
                .setPrefetchDistance(NETWORK_PAGE_SIZE)
                .setEnablePlaceholders(true)
                .build();
    }

    public LiveData<PagedList<Post>> getPostFromDatabase() {
        return new LivePagedListBuilder<>(postsDao.getPostsDataSource(), postsPagingConfig)
                //.setFetchExecutor(myExecutor)
                .build();
    }
}

