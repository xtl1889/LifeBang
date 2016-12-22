package com.pro.xtl1889.lifebang.ui.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.pro.xtl1889.lifebang.Config;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.api.CmsAPI;
import com.pro.xtl1889.lifebang.model.NewData;
import com.pro.xtl1889.lifebang.ui.adapter.NewsHoemAdaper;
import com.pro.xtl1889.lifebang.ui.base.BaseLoadFragment;
import com.pro.xtl1889.lifebang.ui.pull2refresh.PullableRecyclerView;
import com.pro.xtl1889.lifebang.util.LogUtils;
import com.pro.xtl1889.lifebang.util.RetrofitUtils;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by xtl1889 on 16-8-22.
 */
public class NewsFragment extends BaseLoadFragment<NewData> {

    @BindView(R.id.tv)
    TextView tv;

    @BindView(R.id.list)
    PullableRecyclerView mRecyclerView;

    private String pageTag;

    private int mTag;
    private Context mContext;
    private CmsAPI cmsAPI;
    private Call<NewData> call;
    private int newsNum=10,newsPage=1;

    private NewsHoemAdaper madapter;

    public NewsFragment(Context mContext, int mTag) {
        this.mContext = mContext;
        this.mTag = mTag;
        LogUtils.LOGD("------mTag----1--"+mTag);
    }

    @Override
    protected void onLoadData() {
        showLoad();
        pageTag=null;
        LogUtils.LOGD("------mTag----2--"+mTag);
        newsPage=1;
        loadWhichData();
    }

    @Override
    protected void onInitLoadData(NewData pageData) {

        if (pageData!=null&&madapter!=null){
//            LogUtils.LOGD("------------baidu-newdata--size" + pageData.getNewslist().size());
            if (null!=pageTag&&"2".equals(pageTag)){
                madapter.addItems(pageData.getNewslist());
            }else {
                madapter.updateItems(pageData.getNewslist());
            }

        }

    }

    @Override
    public void onLoadMoreData(String tag) {
        super.onLoadMoreData(tag);
        this.pageTag=tag;
        newsPage++;
        loadWhichData();
    }

    private void loadWhichData(){
        cmsAPI= RetrofitUtils.getRestAPI(Config.BaiDu_Url, CmsAPI.class);
        switch (mTag){
            case 1:
//                tv.setText("科技新闻");
                call=cmsAPI.socialNews(String.valueOf(newsNum),String.valueOf(newsPage));
                break;
            case 0:
//                tv.setText("国际新闻");
                call=cmsAPI.worldNews(String.valueOf(newsNum), String.valueOf(newsPage));
                break;
            case 3:
//                tv.setText("体育新闻");
                call=cmsAPI.tiyuNews(String.valueOf(newsNum), String.valueOf(newsPage));
                break;
            case 4:
//                tv.setText("娱乐花边");
                call=cmsAPI.yuleNews(String.valueOf(newsNum), String.valueOf(newsPage));
                break;
            case 2:
//                tv.setText("健康生活");
                call=cmsAPI.health(String.valueOf(newsNum),String.valueOf(newsPage));
                break;
        }

        if (call!=null){
            call.enqueue(this);
            LogUtils.LOGD("------------baidu-newsFragmeng-url--" + call.request().url());
        }
    }
    @Override
    protected void judgePage() {

        setEnableLoadMore(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if (madapter==null){
            madapter=new NewsHoemAdaper(getActivity());
        }
        LogUtils.LOGD("------------baidu-recyclerView---" +mRecyclerView+"----tv---"+tv);
        if(mRecyclerView!=null) {
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setAdapter(madapter);
//            adapter.setListener(this);
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.view_load_recyclerview;
    }

    @Override
    public void onResponse(Call<NewData> call, Response<NewData> response) {

            String s=response.body().getMsg();
            LogUtils.LOGD("------------baidu-cs--"+s);
            LogUtils.LOGD("------------baidu-cs-url--"+call.request().url());

        if (null!=response.body()){
            hideEmptyView();
            setPageData(response.body());
            onRefreshCallback(true);
            return;
        }
        onRefreshCallback(false);
        showConnectionRetry();
    }

    @Override
    public void onFailure(Call<NewData> call, Throwable t) {

        LogUtils.LOGD("------------baidu-sb-url-"+call.request().url());

        onRefreshCallback(false);
        showConnectionRetry();
    }

}
