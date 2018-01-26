package com.kingmo.viewmodelex.model;

import java.util.Random;

/**
 * Created by kingmo on 1/23/18.
 */

public class Item {
    private int id;
    private String message;
    private static final Random randomGen = new Random(5000);

    public Item(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public Item(String message) {
        this.message = message;
        this.id = randomGen.nextInt();
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
