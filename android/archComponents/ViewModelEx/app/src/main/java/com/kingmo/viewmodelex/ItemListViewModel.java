package com.kingmo.viewmodelex;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.kingmo.viewmodelex.model.Item;
import com.kingmo.viewmodelex.repos.ItemRepo;

import java.util.List;

/**
 * Created by kingmo on 1/24/18.
 * 
 * https://jsonplaceholder.typicode.com/
 */

public class ItemListViewModel extends ViewModel {
    private ItemRepo itemRepo;
    private MutableLiveData<String> stringList = new MutableLiveData<>();

    public ItemListViewModel() {
    }

    public ItemListViewModel(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public void setItemRepo(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public LiveData<String> getItemListString() {
        List<Item> itemList = itemRepo.getItems();
        // for example purposes only. in real life, this would be done on a background thread
        if (!itemList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("");
            for (Item it : itemList) {
                stringBuilder.append(it.getMessage()).append("\n");
            }
            stringList.setValue(stringBuilder.toString());
        } else {
            stringList.setValue("No items available.");
        }

        return stringList;
    }

    public void addItem(String message) {
        itemRepo.addItem(new Item(message));

        // get the list String again to trigger live data update
        getItemListString();
    }

//    public void setStringList(MutableLiveData<String> stringList) {
//        this.stringList = stringList;
//    }
}
