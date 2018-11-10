package com.kingmo.pager.ui;

import com.kingmo.pager.database.entity.Post;

import androidx.recyclerview.widget.DiffUtil;

public class PostDiffCallback extends DiffUtil.ItemCallback<Post> {
    @Override
    public boolean areItemsTheSame(Post oldItem, Post newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(Post oldItem, Post newItem) {
        return (oldItem != null && newItem != null) && oldItem.getId() == newItem.getId();
    }
}
