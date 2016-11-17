package com.pro.xtl1889.lifebang.model;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/5/26.
 */
public class NewFragmentModel {
    String tag;
    Fragment fragment;

    public NewFragmentModel(String tag, Fragment fragment) {
        this.tag = tag;
        this.fragment = fragment;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
