package com.kingmo.glideex.viewmodel;

import com.kingmo.glideex.repo.ImageUrlRepo;

import java.util.List;

public class ImageViewModel {
    private ImageUrlRepo imageUrlRepo;

    public ImageViewModel(ImageUrlRepo imageUrlRepo) {
        this.imageUrlRepo = imageUrlRepo;
    }

    public List<String> getImages() {
        return imageUrlRepo.getImageList();
    }
}
