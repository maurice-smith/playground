package com.kingmo.pager;

import android.os.Bundle;

import com.kingmo.pager.api.PostServiceManager;
import com.kingmo.pager.api.services.PostApiService;
import com.kingmo.pager.database.AppDatabase;
import com.kingmo.pager.network.ServiceGenerator;
import com.kingmo.pager.ui.PostsRecyclerAdapter;
import com.kingmo.pager.viewModel.UserPostViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView postList;
    private AppDatabase appDatabase;
    private PostRepo postRepo;
    private PostsRecyclerAdapter postsRecyclerAdapter;
    private UserPostViewModel userPostViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appDatabase = AppDatabase.getInstance(this);

        postRepo = new PostRepo(appDatabase.getPostDao(),
                new PostServiceManager(ServiceGenerator.createService(PostApiService.class)),
                new SharedPrefManager(this));

        userPostViewModel = ViewModelProviders.of(this).get(UserPostViewModel.class);
        userPostViewModel.setPostRepo(postRepo);

        postList = findViewById(R.id.postList);
        postList.setLayoutManager(new LinearLayoutManager(this));

        postsRecyclerAdapter = new PostsRecyclerAdapter(getResources());

        userPostViewModel.getPostData().observe(this, postsRecyclerAdapter::submitList);
    }
}
