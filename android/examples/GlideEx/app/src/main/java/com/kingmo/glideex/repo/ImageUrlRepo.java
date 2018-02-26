package com.kingmo.glideex.repo;

import java.util.ArrayList;
import java.util.List;

public class ImageUrlRepo {

    private static final List<String> IMGAE_LIST = new ArrayList<>();

    static {
        IMGAE_LIST.add("http://bestanimations.com/Animals/Mammals/Cats/Lions/lion-gif-animation-8.gif");
        IMGAE_LIST.add("https://kids.nationalgeographic.com/content/dam/kids/photos/animals/Mammals/H-P/lion-male-roar.adapt.945.1.jpg");
        IMGAE_LIST.add("https://kids.nationalgeographic.com/content/dam/kids/photos/animals/Mammals/H-P/lion-pride.adapt.945.1.jpg");
        IMGAE_LIST.add("https://kids.nationalgeographic.com/content/dam/kids/photos/animals/Mammals/H-P/photoark-lion.adapt.945.1.png");
        IMGAE_LIST.add("https://kids.nationalgeographic.com/content/dam/kids/photos/animals/Mammals/H-P/lion-pride.adapt.945.1.jpg");
        IMGAE_LIST.add("https://kids.nationalgeographic.com/content/dam/kids/photos/animals/Mammals/H-P/lion-cub-yawning.adapt.945.1.jpg");
        IMGAE_LIST.add("https://kids.nationalgeographic.com/content/dam/kids/photos/articles/Other%20Explore%20Photos/R-Z/Wacky%20Weekend/Wild%20Cats/ww-wild-cats-lion.adapt.945.1.jpg");
        IMGAE_LIST.add(null);
        IMGAE_LIST.add("http://kids.sandiegozoo.org/sites/default/files/2017-07/animal-hero-rhinos.jpg");
        IMGAE_LIST.add("http://7wallpapers.net/wp-content/uploads/2016/06/5_Rhinoceros.jpg");
    }

    public List<String> getImageList() {
        return IMGAE_LIST;
    }
}
