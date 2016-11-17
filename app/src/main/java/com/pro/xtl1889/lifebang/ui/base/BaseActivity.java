package com.pro.xtl1889.lifebang.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pro.xtl1889.lifebang.util.UserInfo;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xtl1889 on 16-7-24.
 */
public abstract class BaseActivity extends AppCompatActivity{

    public UserInfo mUserInfo;
    private Unbinder unbinder;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        unbinder=ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
