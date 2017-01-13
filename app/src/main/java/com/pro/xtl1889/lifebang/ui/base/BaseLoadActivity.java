package com.pro.xtl1889.lifebang.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.ui.pull2refresh.PullToRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Callback;


/**
 * Created by zuoxian on 15/9/7.
 */
public abstract class BaseLoadActivity<T> extends AppCompatActivity implements Callback<T> {

    private Menu mMenu;
    private Unbinder unbinder;

    @Nullable
    @BindView(R.id.toolbar)
    protected
    Toolbar toobar;

    @Nullable
    @BindView(R.id.ivLogo)
    ImageView ivLogo;

    @Nullable
    @BindView(R.id.toolbar_title)
    public TextView customTitle;

    @Nullable
    @BindView(R.id.movie_icon)
    public ImageView movie_icon;

    @Nullable
    @BindView(R.id.movie_icon_layout)

    public MenuItem search_item;
    public boolean mIsOnPause;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
//        ButterKnife.bind(this);

        unbinder=ButterKnife.bind(this);
        setupToolbar();


    }

    protected void setupToolbar() {
        if (toobar != null) {
            setSupportActionBar(toobar);
        }
    }

    public void setMovieIcon(int drawableId){
        movie_icon.setBackgroundResource(drawableId);
    }

    public void setCustomTitle(String title) {
        if (customTitle != null) {
            customTitle.setText(title);
        }
    }

    public Toolbar getToobar() {
        return toobar;
    }

    public ImageView getIvLogo() {
        return ivLogo;
    }

    protected void hideTitle(boolean isVisiable) {
        if (customTitle != null) {
            customTitle.setVisibility(isVisiable ? View.VISIBLE : View.GONE);
        }
    }

    public void onResume() {
        super.onResume();
        mIsOnPause = false;
//        MobclickAgent.onResume(this);

        if (mPullToRefreshLayout != null) {
            if(!enableLoadMore){
                LayoutInflater inflater = (LayoutInflater)this.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                mPullToRefreshLayout.setCustomLoadmoreView(inflater.inflate(R.layout.empty_view, null));
            }
            mPullToRefreshLayout.setOnPullListener(new PullToRefreshLayout.OnPullListener() {
                @Override
                public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
                    mIsPullToRefresh = true;
                    onLoadData();
                }

                @Override
                public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
                    mPullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                    onLoadData();
                }
            });
        }

    }

    public void onPause() {
        super.onPause();
        mIsOnPause = true;
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ButterKnife.unbind(this);
        unbinder.unbind();
    }



    protected T mPageData ;
    protected boolean isLoading;
    protected boolean mIsPullToRefresh = false;
    protected boolean enableLoadMore = false;

    @Nullable
    @BindView(android.R.id.empty)
    protected View mEmptyView;

    @Nullable
    @BindView(R.id.empty_load)
    LinearLayout mEmptyProgressbar;


    @Nullable
    @BindView(R.id.empty_button)
    Button mEmptyButton;

    @Nullable
    @BindView(R.id.pull_to_refresh)
    protected PullToRefreshLayout mPullToRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        PushAgent.getInstance(this).onAppStart();
//        onLoadData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onLoadData();
    }

    protected abstract void onLoadData();

    protected abstract void onInitLoadData(T pageData);

//    protected abstract void onLoadMoreData();


    protected void setPageData(T page_data){
        this.mPageData = page_data;
        onInitLoadData(page_data);
    }

    protected void showLoad() {
        if(this == null) return ;
        if(mPageData != null) return ;
        if (mEmptyView != null) mEmptyView.setVisibility(View.VISIBLE);
        if (mEmptyProgressbar != null) mEmptyProgressbar.setVisibility(View.VISIBLE);
        if (mEmptyButton != null) mEmptyButton.setVisibility(View.GONE);
    }

    protected void showConnectionRetry() {
        if(this == null) return ;
        if (mPageData != null) return ;
        if (mEmptyView != null) mEmptyView.setVisibility(View.VISIBLE);
        if (mEmptyProgressbar != null) mEmptyProgressbar.setVisibility(View.GONE);

        if (mEmptyButton != null) {
            mEmptyButton.setText(getString(R.string.string_retry));
            mEmptyButton.setVisibility(View.VISIBLE);
            mEmptyButton.setOnClickListener(mOnClickListener);
        }
    }


    protected void hideEmptyView(){
        if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
    }

    protected View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mIsPullToRefresh = false;
            showLoad();
            onLoadData();
        }
    };



    protected void onRefreshCallback(boolean succeed) {
        if (mIsPullToRefresh && mPullToRefreshLayout != null) {
            if (succeed) {
                mPullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
            } else {
                mPullToRefreshLayout.refreshFinish(PullToRefreshLayout.FAIL);
            }
        }
    }

    protected void onLoadMoreCallback(boolean succeed) {
        if (mPullToRefreshLayout != null) {
            if (succeed) {
                mPullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
            } else {
                mPullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.FAIL);
            }
        }
    }

    public void setEnableRefresh(){
        if (mPullToRefreshLayout!=null)mPullToRefreshLayout.setPullDownEnable(false);
    }

    public void setEnableLoadMore(boolean flag){
        enableLoadMore = flag;
    }

}
