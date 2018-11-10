package com.kingmo.pager.ui;

import android.content.res.Resources;
import androidx.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kingmo.pager.R;
import com.kingmo.pager.database.entity.Post;
import com.kingmo.pager.databinding.ItemRowBinding;

import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PostsRecyclerAdapter extends PagedListAdapter<Post, PostsRecyclerAdapter.PostViewHolder> {

    private static DiffUtil.ItemCallback<Post> DIFF_CALLBACK = new PostDiffCallback();
    private Resources resources;

    public PostsRecyclerAdapter(Resources resources) {
        super(DIFF_CALLBACK);
        this.resources = resources;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_row, parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.itemRowBinding.setPostViewModel(new PostViewModel(resources, getItem(position)));
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        ItemRowBinding itemRowBinding;

        PostViewHolder(ItemRowBinding binding) {
            super(binding.getRoot());
            itemRowBinding = binding;
        }
    }
}
