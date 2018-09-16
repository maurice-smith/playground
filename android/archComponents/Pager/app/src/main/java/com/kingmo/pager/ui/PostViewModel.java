package com.kingmo.pager.ui;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

import com.kingmo.pager.R;

public class PostViewModel implements Parcelable {
    private long userId;
    private long id;
    private String title;
    private String body;
    private Resources resources;

    // Creator
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public PostViewModel createFromParcel(Parcel in) {
            return new PostViewModel(in);
        }

        public PostViewModel[] newArray(int size) {
            return new PostViewModel[size];
        }
    };

    public PostViewModel(Parcel dest) {
        dest.writeLong(userId);
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(body);
    }

    public PostViewModel(long userId, long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        userId = parcel.readLong();
        id = parcel.readLong();
        title = parcel.readString();
        body = parcel.readString();
    }

    public String getUserIdText() {
        return resources.getString(R.string.post_userId, userId);
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getIdText() {
        return resources.getString(R.string.post_id, id);
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }
}
