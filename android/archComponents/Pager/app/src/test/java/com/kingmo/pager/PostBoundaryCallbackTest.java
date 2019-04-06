package com.kingmo.pager;

import com.kingmo.pager.api.models.ApiPost;
import com.kingmo.pager.database.entity.Post;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static com.kingmo.pager.PostRepo.NETWORK_PAGE_SIZE;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostBoundaryCallbackTest {

    @Mock
    private PostRepo postRepo;
    private PostBoundaryCallback boundaryCallback;

    @Before
    public void setUp() throws Exception {
        boundaryCallback = new PostBoundaryCallback(postRepo);
    }

    @After
    public void tearDown() throws Exception {
        postRepo = null;
        boundaryCallback = null;
    }

    @Test
    public void shouldLoadInitialItems() {
        ApiPost apiPost = mock(ApiPost.class);
        when(apiPost.getId()).thenReturn(2L);
        when(apiPost.getUserId()).thenReturn(4L);
        when(apiPost.getTitle()).thenReturn("Title");
        when(apiPost.getBody()).thenReturn("Body");

        when(postRepo.getPostsFromApi(0, NETWORK_PAGE_SIZE))
                .thenReturn(Observable.just(Collections.singletonList(apiPost)));

        boundaryCallback.onZeroItemsLoaded();

        verify(postRepo).saveLastFetchedStartIndex(eq(0));
        verify(postRepo).getPostsFromApi(eq(0), eq(NETWORK_PAGE_SIZE));
        verify(postRepo).saveToDatabase(anyList());
    }

    @Test
    public void shouldLoadNextItemsFromApi() {}
}