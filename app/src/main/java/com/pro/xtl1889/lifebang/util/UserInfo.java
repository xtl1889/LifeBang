package com.pro.xtl1889.lifebang.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xtl1889 on 16-7-22.
 */
public class UserInfo {
    private final String isFisrst="first";
    private Context mContext;
    private SharedPreferences sharedPreferences;

    public UserInfo(Context mContext) {
        this.mContext = mContext;
        if (sharedPreferences==null)sharedPreferences=mContext.getSharedPreferences(isFisrst,Context.MODE_APPEND);
    }

    public boolean booleanIsFirst(){
        boolean b=sharedPreferences.getBoolean(isFisrst,true);
        return b;
    }

    public void setIsFisrst(boolean b){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(isFisrst,b);
        editor.commit();
    }
}
