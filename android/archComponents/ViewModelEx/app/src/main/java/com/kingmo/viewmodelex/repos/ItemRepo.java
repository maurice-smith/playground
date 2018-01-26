package com.kingmo.viewmodelex.repos;

import android.support.annotation.NonNull;

import com.kingmo.viewmodelex.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kingmo on 1/23/18.
 */

public class ItemRepo {
    private List<Item> iList = new ArrayList<>();

    @NonNull
    public List<Item> getItems() {
        return iList;
    }

    public void addItem(Item newItem) {
        Collections.addAll(iList, newItem);
    }

    public void deleteItem(Item item) {
        iList.remove(item);
    }
}
