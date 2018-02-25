package com.kingmo.glideex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kingmo.glideex.repo.ImageUrlRepo;
import com.kingmo.glideex.viewmodel.ImageViewModel;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();

    private RecyclerView imgList;
    private ImageViewModel imageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewModel = new ImageViewModel(new ImageUrlRepo());

        ImagesAdapter imagesAdapter = new ImagesAdapter(this, imageViewModel.getImages());

        imgList = findViewById(R.id.imgList);
        imgList.setLayoutManager(new LinearLayoutManager(this));
        imgList.setAdapter(imagesAdapter);
    }
}
