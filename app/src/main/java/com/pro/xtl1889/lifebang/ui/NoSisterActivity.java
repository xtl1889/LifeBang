package com.pro.xtl1889.lifebang.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.pro.xtl1889.lifebang.Config;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.api.CmsAPI;
import com.pro.xtl1889.lifebang.model.NoSisterModle;
import com.pro.xtl1889.lifebang.ui.adapter.NoSisterAdapter;
import com.pro.xtl1889.lifebang.ui.base.BaseLoadActivity;
import com.pro.xtl1889.lifebang.ui.pull2refresh.PullToRefreshLayout;
import com.pro.xtl1889.lifebang.ui.pull2refresh.PullableRecyclerView;
import com.pro.xtl1889.lifebang.util.LogUtils;
import com.pro.xtl1889.lifebang.util.RetrofitUtils;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Response;

public class NoSisterActivity extends BaseLoadActivity<NoSisterModle> {
    @BindView(R.id.no_sister_list)
    PullableRecyclerView no_sister_list;
    @BindView(R.id.pull_to_refresh)
    PullToRefreshLayout pull_to_refresh;

    private CmsAPI cmsApi;
    private Call<NoSisterModle> call;

    private NoSisterAdapter noSisterAdapter;
    private int mPage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_sister);
        setEnableLoadMore(true);
        initView();
    }

    private void initView() {
        noSisterAdapter=new NoSisterAdapter(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if (no_sister_list!=null){
            no_sister_list.setLayoutManager(linearLayoutManager);
            no_sister_list.setHasFixedSize(true);
            no_sister_list.setAdapter(noSisterAdapter);
        }
    }

    @Override
    protected void onLoadData() {
        getData();
    }

    @Override
    protected void onInitLoadData(NoSisterModle pageData) {

        LogUtils.LOGD("noSister----onInitLoadData---code---" + pageData.getShowapi_res_code());
        if (pageData!=null&&0==pageData.getShowapi_res_code()){
            if (mPage==1){
                noSisterAdapter.updateItems(pageData.getShowapi_res_body().getPagebean().getContentlist());
            }else {
                noSisterAdapter.addItems(pageData.getShowapi_res_body().getPagebean().getContentlist());
            }
        }
    }

    @Override
    protected void onLoadMoreData() {
        mPage++;
        getData();
    }

    private void getData() {
        cmsApi= RetrofitUtils.getRestAPI(Config.YiYuan_Url,CmsAPI.class);
        call=cmsApi.noSister("30576", "05d26bb7715c48a1a156772da6d38106",
                "", "", String.valueOf(mPage));
        call.enqueue(this);
        LogUtils.LOGD("noSister----url--" + call.request().url()+
                "\n----mPage---"+mPage);
    }

    @Override
    public void onResponse(Call<NoSisterModle> call, Response<NoSisterModle> response) {
        LogUtils.LOGD("noSister--cg--"+response.body());

        if (null!=response.body()){
            hideEmptyView();
            setPageData(response.body());
            onRefreshCallback(true);
        }
        onRefreshCallback(false);
        showConnectionRetry();

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        LogUtils.LOGD("noSister--sb--"+call.request().body());
        onRefreshCallback(false);
        showConnectionRetry();
    }
}
