package com.pro.xtl1889.lifebang.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pro.xtl1889.lifebang.ui.pull2refresh.PullToRefreshLayout;
import com.pro.xtl1889.lifebang.R;

import butterknife.BindView;
import retrofit2.Callback;

/**
 * Created by zuoxian on 15/9/7.
 */
public abstract class BaseLoadFragment<T> extends BaseFragment implements Callback<T> {

    protected T mPageData ;
    protected boolean isLoading;
    protected boolean mIsPullToRefresh = false;
    protected boolean enableLoadMore = false;


    @Nullable
    @BindView(android.R.id.empty)
    protected View mEmptyView;



    @Nullable
    @BindView(R.id.empty_text)
    protected TextView mEmpty_text;

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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        judgePage();
        if(mPageData == null) {
            mIsPullToRefresh = false;
            onLoadData();
        }else{
            onInitLoadData(mPageData);
        }

        if (mPullToRefreshLayout != null) {
            if(!enableLoadMore){
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(
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
                    onLoadMoreData("2");
                }
            });
        }
    }



    protected abstract void onLoadData();

    protected abstract void onInitLoadData(T pageData);

    public void onLoadMoreData(String tag) {

    }

    protected abstract void judgePage();

    protected void setPageData(T page_data){
        this.mPageData = page_data;
        onInitLoadData(page_data);
    }

    protected void showLoad() {
        if(getActivity() == null) return ;
        if(mPageData != null) return ;
        if (mEmptyView != null) mEmptyView.setVisibility(View.VISIBLE);
        if (mEmptyProgressbar != null) mEmptyProgressbar.setVisibility(View.VISIBLE);
        if (mEmptyButton != null) mEmptyButton.setVisibility(View.GONE);
    }

    protected void showConnectionRetry() {
        if(getActivity() == null) return ;
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
