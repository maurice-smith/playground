package com.kingmo.glideex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.util.FixedPreloadSizeProvider;
import com.kingmo.glideex.repo.ImageUrlRepo;
import com.kingmo.glideex.viewmodel.ImageViewModel;

import static com.kingmo.glideex.ImagesAdapter.getDefaultImgHeightPixels;
import static com.kingmo.glideex.ImagesAdapter.getDefaultImgWidthPixels;

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
        ListPreloader.PreloadSizeProvider<String> sizeProvider = new FixedPreloadSizeProvider<>(getDefaultImgWidthPixels(this),
                getDefaultImgHeightPixels(this));

        RecyclerViewPreloader<String> imagePreLoader = new RecyclerViewPreloader<>(this,
                imagesAdapter,
                sizeProvider, 2);

        imgList = findViewById(R.id.imgList);
        imgList.setLayoutManager(new LinearLayoutManager(this));
        imgList.addOnScrollListener(imagePreLoader);
        imgList.setAdapter(imagesAdapter);
    }
}
