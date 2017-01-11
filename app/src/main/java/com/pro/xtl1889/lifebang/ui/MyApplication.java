package com.pro.xtl1889.lifebang.ui;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by lianbinbo on 2017/1/11.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
