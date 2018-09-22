package com.kingmo.pager.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.kingmo.pager.R;
import com.kingmo.pager.database.entity.Post;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PostsRecyclerAdapter extends PagedListAdapter<Post, PostsRecyclerAdapter.PostViewHolder> {

    private static DiffUtil.ItemCallback<Post> DIFF_CALLBACK = new PostDiffCallback();

    private Context context;
    private FragmentManager fragmentManager;

    public PostsRecyclerAdapter(Context context, FragmentManager fragmentManager) {
        super(DIFF_CALLBACK);
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = getItem(position);
        PostViewModel postViewModel = new PostViewModel(post.getUserId(),
                post.getId(), post.getTitle(), post.getBody());

        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(position + 1); //since id cannot be zero

        //fragmentManager.popBackStack(fragTag, 0);
        fragmentManager.beginTransaction().replace(frameLayout.getId(),
                UserPostFragment.newInstance(postViewModel)).commit();

        holder.itemRowContainer.addView(frameLayout);
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout itemRowContainer;

        PostViewHolder(View itemView) {
            super(itemView);
            itemRowContainer = itemView.findViewById(R.id.item_container);
        }
    }
}
