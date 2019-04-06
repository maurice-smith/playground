package com.kingmo.pager;

import com.kingmo.pager.api.PostServiceManager;
import com.kingmo.pager.api.models.ApiPost;
import com.kingmo.pager.database.PostsDao;
import com.kingmo.pager.database.entity.Post;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostRepoTest {

    @Mock
    private PostsDao postsDao;
    @Mock
    private SharedPrefManager prefManager;
    @Mock
    private PostServiceManager postServiceManager;
    private PostRepo postRepo;

    @Before
    public void setUp() {
        postRepo = new PostRepo(postsDao, postServiceManager, prefManager);
    }

    @After
    public void tearDown() {
        postRepo = null;
        postsDao = null;
        postServiceManager = null;
        prefManager = null;
    }

    @Test
    public void shouldSaveApiPostToDataBase() {
        ApiPost apiPost = mock(ApiPost.class);
        when(apiPost.getId()).thenReturn(2L);
        when(apiPost.getUserId()).thenReturn(4L);
        when(apiPost.getTitle()).thenReturn("Title");
        when(apiPost.getBody()).thenReturn("Body");

        postRepo.saveToDatabase(apiPost);

        Post dbPost = new Post(4L, 2L, "Title", "Body");
        verify(postsDao).add(eq(dbPost));
    }

    @Test
    public void shouldNotSaveEmptyPostListToDataBase() {
        postRepo.saveToDatabase(new ArrayList<>());

        verify(postsDao, never()).add(anyList());
    }

    @Test
    public void shouldSaveApiPostListToDataBase() {
        ApiPost apiPost1 = mock(ApiPost.class);
        ApiPost apiPost2 = mock(ApiPost.class);

        postRepo.saveToDatabase(Arrays.asList(apiPost1, apiPost2));

        verify(postsDao, times(2)).add(isA(Post.class));
    }

    @Test
    public void shouldClearDataBaseAndSharedPrefs() {
        postRepo.clearDatabase();

        verify(postsDao).deleteAll();
        verify(prefManager).remove(isA(String.class));
    }

    @Test
    public void shouldRemovePostFromDataBase() {
        postRepo.removePostFromDatabase(mock(Post.class));

        verify(postsDao).delete(isA(Post.class));
    }
}