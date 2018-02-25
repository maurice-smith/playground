package com.kingmo.glideex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder> {
    private List<String> images;
    private RequestManager glide;

    public ImagesAdapter(Context context, List<String> images) {
        this.images = images;
        this.glide = Glide.with(context);

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.generic_placeholder)
                .error(R.drawable.generic_placeholder)
                .fitCenter();

        glide.applyDefaultRequestOptions(requestOptions);
    }

    @Override
    public ImagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImagesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.img_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ImagesViewHolder holder, int position) {
        glide.load(getItem(position)).into(holder.regImage);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public String getItem(int position) {
        return images.get(position);
    }

    static class ImagesViewHolder extends RecyclerView.ViewHolder {
        ImageView regImage;

        public ImagesViewHolder(View itemView) {
            super(itemView);
            regImage = itemView.findViewById(R.id.regImage);
        }
    }
}
