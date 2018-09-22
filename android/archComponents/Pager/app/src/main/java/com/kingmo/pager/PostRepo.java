package com.kingmo.pager;

import com.kingmo.pager.api.PostServiceManager;
import com.kingmo.pager.api.models.ApiPost;
import com.kingmo.pager.database.PostsDao;
import com.kingmo.pager.database.entity.Post;

import java.util.List;

import androidx.paging.DataSource;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class PostRepo {
    public static final int NETWORK_PAGE_SIZE = 10;

    private static final String LAST_FETCHED_START_INDEX_KEY = "LAST_FETCHED_START_INDEX";

    private PostsDao postsDao;
    private PostServiceManager serviceManager;
    private SharedPrefManager prefManager;

    public PostRepo(PostsDao postsDao, PostServiceManager serviceManager, SharedPrefManager prefManager) {
        this.postsDao = postsDao;
        this.serviceManager = serviceManager;
        this.prefManager = prefManager;
    }

    public void saveToDatabase(ApiPost post) {
        postsDao.add(new Post(post.getUserId(), post.getId(),
                post.getTitle(), post.getBody()));
    }

    public void saveToDatabase(List<ApiPost> posts) {
        if (posts == null || posts.isEmpty()) {
            return;
        }

        for (ApiPost apiPost : posts) {
            saveToDatabase(apiPost);
        }
    }

    public void removePostFromDatabase(Post post) {
        postsDao.delete(post);
    }

    public void clearDatabase() {
        prefManager.remove(LAST_FETCHED_START_INDEX_KEY);
        postsDao.deleteAll();
    }

    public Observable<List<ApiPost>> getPostsFromApi(int startIndex, int limit) {
        return serviceManager.getPosts(startIndex, limit);
    }

    public Flowable<List<Post>> getPostsFromDB() {
        return postsDao.getPosts();
    }

    public void saveLastFetchedStartIndex(int startIndex) {
        prefManager.save(LAST_FETCHED_START_INDEX_KEY, startIndex);
    }

    public int getLastFetchedStartIndex() {
        return prefManager.getIntValue(LAST_FETCHED_START_INDEX_KEY);
    }

    public DataSource.Factory<Integer, Post> getPostsDataSource() {
        return postsDao.getPostsDataSource();
    }
}
