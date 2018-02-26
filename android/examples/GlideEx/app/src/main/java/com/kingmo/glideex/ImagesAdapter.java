package com.kingmo.glideex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import static com.kingmo.glideex.utils.Utils.convertDpToPixels;

import java.util.Collections;
import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>
        implements ListPreloader.PreloadModelProvider<String> {

    private static final int IMG_WIDTH_DP = 125;
    private static final int IMG_HEIGHT_DP = 125;

    private List<String> images;
    private RequestManager glideRequestManager;

    public ImagesAdapter(Context context, List<String> images) {
        this.images = images;
        this.glideRequestManager = Glide.with(context);

        glideRequestManager.applyDefaultRequestOptions(getRequestOptions(context));
    }

    @Override
    public ImagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImagesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.img_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ImagesViewHolder holder, int position) {
        glideRequestManager.load(getItem(position)).into(holder.regImage);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @NonNull
    @Override
    public List<String> getPreloadItems(int position) {
        return TextUtils.isEmpty(getItem(position))
                ? Collections.singletonList(getItem(position)) : Collections.emptyList();
    }

    @Nullable
    @Override
    public RequestBuilder getPreloadRequestBuilder(@NonNull String item) {
        return glideRequestManager.load(item);
    }

    public String getItem(int position) {
        return images.get(position);
    }

    public static RequestOptions getRequestOptions(Context context) {
        return new RequestOptions()
                .error(R.drawable.generic_placeholder)
                .placeholder(R.drawable.generic_placeholder)
                .override(convertDpToPixels(IMG_WIDTH_DP, context),
                        convertDpToPixels(IMG_HEIGHT_DP, context));
    }

    public static int getDefaultImgWidthPixels(Context context) {
        return convertDpToPixels(IMG_WIDTH_DP, context);
    }

    public static int getDefaultImgHeightPixels(Context context) {
        return convertDpToPixels(IMG_HEIGHT_DP, context);
    }

    static class ImagesViewHolder extends RecyclerView.ViewHolder {
        ImageView regImage;

        public ImagesViewHolder(View itemView) {
            super(itemView);
            regImage = itemView.findViewById(R.id.regImage);
        }
    }
}
