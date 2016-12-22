package com.pro.xtl1889.lifebang.model;

import android.graphics.Bitmap;

/**
 * Created by xtl1889 on 16-9-3.
 */
public class LiveModel {
    private int liveTag;
    private String title;
    private String imgUrl;
    private Bitmap bitmap;
    private int id_iv;

    public int getLiveTag() {
        return liveTag;
    }

    public void setLiveTag(int liveTag) {
        this.liveTag = liveTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getId_iv() {
        return id_iv;
    }

    public void setId_iv(int id_iv) {
        this.id_iv = id_iv;
    }
}
