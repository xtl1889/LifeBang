package com.pro.xtl1889.lifebang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.ui.adapter.ViewPagerAdapter;
import com.pro.xtl1889.lifebang.ui.base.BaseActivity;
import com.pro.xtl1889.lifebang.util.SystemTools;
import com.pro.xtl1889.lifebang.util.UserInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WelcomActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.iv_splash_ad)
    View iv_ad;
    @BindView(R.id.firstComein)
    View firstCome_view;
    @BindView(R.id.viewpager)
    ViewPager vp;
    @BindView(R.id.pager_indicator)
    ViewGroup mGroup;

    private ViewPagerAdapter vpAdapter;
    private List<View> views;
    private ImageView mImageView;
    private ImageView[] mImageViews;

    private boolean isFirst;


    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            iv_ad.setVisibility(View.VISIBLE);
          handler.sendEmptyMessageDelayed(0, 2000);

        }
    };


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(WelcomActivity.this,MainActivity.class));

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        mUserInfo=new UserInfo(this);
        isFirst=mUserInfo.booleanIsFirst();
        booleanIsFirst();
    }

    private void booleanIsFirst() {
        if (isFirst){
            mUserInfo.setIsFisrst(false);
            showWelcomeView();
        }else {
            iv_ad.postDelayed(runnable,2000);
        }
    }

    private void showWelcomeView(){
        firstCome_view.setVisibility(View.VISIBLE);

        final LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        final View v1=inflater.inflate(R.layout.splash_one, null);
        final View v2=inflater.inflate(R.layout.splash_two, null);
        final View v3=inflater.inflate(R.layout.splash_three, null);
        views.add(v1);
        views.add(v2);
        views.add(v3);
//		 初始化Adapter
        vpAdapter = new ViewPagerAdapter(views, WelcomActivity.this);

        vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);
        // 绑定回调
        vp.setOnPageChangeListener(WelcomActivity.this);


        mImageViews = new ImageView[views.size()];
        mGroup = (ViewGroup)findViewById(R.id.pager_indicator);
        int width = SystemTools.dip2px(this, 42);
        int height = SystemTools.dip2px(this, 25);
        for (int i = 0; i < views.size(); i++) {
            mImageView = new ImageView(this);
            mImageView.setLayoutParams(new ViewGroup.LayoutParams(width, height));
            mImageViews[i] = mImageView;

            if (i == 0) {
                //默认选中第一张图片
                mImageViews[i].setBackgroundResource(R.drawable.ic_indicator_sel);
            } else {
                mImageViews[i].setBackgroundResource(R.drawable.ic_indicator_nor);
            }

            mGroup.addView(mImageViews[i]);
        }


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        for (int i = 0; i < mImageViews.length; i++) {
            mImageViews[position].setBackgroundResource(R.drawable.ic_indicator_sel);

            if (position != i) {
                mImageViews[i].setBackgroundResource(R.drawable.ic_indicator_nor);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
