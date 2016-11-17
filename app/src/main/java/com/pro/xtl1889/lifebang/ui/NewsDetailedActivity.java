package com.pro.xtl1889.lifebang.ui;

import android.os.Bundle;
import android.webkit.WebView;

import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.ui.base.BaseActivity;
import com.pro.xtl1889.lifebang.util.LogUtils;

import butterknife.BindView;

public class NewsDetailedActivity extends BaseActivity {

    @BindView(R.id.NewsWeb)
    WebView webView;

    private String newUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detailed);
        newUrl=getIntent().getStringExtra("newUrl");
        LogUtils.LOGD("--------newUrl----1-"+newUrl);
        initView();
    }

    private void initView() {
        if (null!=newUrl){
            LogUtils.LOGD("--------newUrl----2-"+newUrl);
            webView.loadUrl(newUrl);
        }
    }
}
