package com.pro.xtl1889.lifebang.ui;

import android.os.Bundle;

import com.pro.xtl1889.lifebang.Config;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.api.CmsAPI;
import com.pro.xtl1889.lifebang.model.NoSisterModle;
import com.pro.xtl1889.lifebang.ui.base.BaseLoadActivity;
import com.pro.xtl1889.lifebang.ui.pull2refresh.PullableRecyclerView;
import com.pro.xtl1889.lifebang.util.LogUtils;
import com.pro.xtl1889.lifebang.util.RetrofitUtils;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Response;

public class NoSisterActivity extends BaseLoadActivity<NoSisterModle> {
    @BindView(R.id.no_sister_list)
    PullableRecyclerView no_sister_list;


    private CmsAPI cmsApi;
    private Call<NoSisterModle> call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_sister);
    }

    @Override
    protected void onLoadData() {
        getData();
    }

    @Override
    protected void onInitLoadData(NoSisterModle pageData) {

    }

    private void getData() {
        cmsApi= RetrofitUtils.getRestAPI(Config.YiYuan_Url,CmsAPI.class);
        call=cmsApi.noSister("30576", "05d26bb7715c48a1a156772da6d38106",
                "", "", "");
        call.enqueue(this);
        LogUtils.LOGD("noSister----url--" + call.request().url());
    }

    @Override
    public void onResponse(Call call, Response response) {
        LogUtils.LOGD("noSister--cg--"+response.body());

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        LogUtils.LOGD("noSister--sb--"+call.request().body());
    }
}
