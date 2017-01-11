package com.pro.xtl1889.lifebang.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.TextureView;
import android.widget.TextView;

import com.pro.xtl1889.lifebang.Config;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.api.CmsAPI;
import com.pro.xtl1889.lifebang.model.FunsModel;
import com.pro.xtl1889.lifebang.ui.adapter.FunsGifFunsAdapter;
import com.pro.xtl1889.lifebang.ui.adapter.FunsImageFunsAdapter;
import com.pro.xtl1889.lifebang.ui.adapter.FunsTextFunsAdapter;
import com.pro.xtl1889.lifebang.ui.adapter.NewsHoemAdaper;
import com.pro.xtl1889.lifebang.ui.base.BaseLoadFragment;
import com.pro.xtl1889.lifebang.ui.pull2refresh.PullableRecyclerView;
import com.pro.xtl1889.lifebang.util.LogUtils;
import com.pro.xtl1889.lifebang.util.RetrofitUtils;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lianbinbo on 2016/12/22.
 */
public class FunsFragment extends BaseLoadFragment<FunsModel> {

    @BindView(R.id.tv)
    TextView tv;

    @BindView(R.id.list)
    PullableRecyclerView rv_funsFargment;

    private FunsTextFunsAdapter funsTextFunsAdapter;
    private FunsImageFunsAdapter funsImageFunsAdapter;
    private FunsGifFunsAdapter funsGifFunsAdapter;

    private Context mContext;
    private int tag;//标记   加载那种内容
    private String mTag="341-1";//区分 文本(341-1)/图片(341-2)/动态图(341-3)
    private int mPage=1;


    private CmsAPI cmsAPI;
    private Call<FunsModel> funsModelCall;
    public FunsFragment(Context mContext, int tag) {
        this.mContext = mContext;
        this.tag = tag;
    }

    private void getmTag(){
        switch (tag){
            case 0:
                mTag="341-1";
                funsTextFunsAdapter=new FunsTextFunsAdapter(getActivity());
                if (rv_funsFargment!=null){
                    rv_funsFargment.setAdapter(funsTextFunsAdapter);
                }
                break;
            case 1:
                mTag="341-2";
                funsImageFunsAdapter=new FunsImageFunsAdapter(getActivity());
                if (rv_funsFargment!=null){
                    rv_funsFargment.setAdapter(funsImageFunsAdapter);
                }
                break;
            case 2:
                mTag="341-3";
                funsGifFunsAdapter=new FunsGifFunsAdapter(getActivity());
                if (rv_funsFargment!=null){
                    rv_funsFargment.setAdapter(funsGifFunsAdapter);
                }
                break;
        }
    }
    @Override
    protected void onLoadData() {
        getmTag();
        loadWhichData();
    }

    @Override
    protected void onInitLoadData(FunsModel pageData) {
        if (pageData!=null){
            LogUtils.LOGD("pageData------"+pageData);
            switch (tag){
                case 0:
                    if (mPage==1){
                        funsTextFunsAdapter.updateItems(pageData.getShowapi_res_body().getContentlist());
                    }else {
                        funsTextFunsAdapter.addItems(pageData.getShowapi_res_body().getContentlist());
                    }
                    break;
                case 1:
                    if (mPage==1){
                        funsImageFunsAdapter.updateItems(pageData.getShowapi_res_body().getContentlist());
                    }else {
                        funsImageFunsAdapter.addItems(pageData.getShowapi_res_body().getContentlist());
                    }
                    break;
                case 2:
                    if (mPage==1){
                        funsGifFunsAdapter.updateItems(pageData.getShowapi_res_body().getContentlist());
                    }else {
                        funsGifFunsAdapter.addItems(pageData.getShowapi_res_body().getContentlist());
                    }
                    break;
            }
        }

    }

    @Override
    protected void judgePage() {
        setEnableLoadMore(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if(rv_funsFargment!=null) {
            rv_funsFargment.setLayoutManager(mLayoutManager);
            rv_funsFargment.setHasFixedSize(true);
        }
    }

    @Override
    public void onLoadMoreData(String tag) {
        super.onLoadMoreData(tag);
        mPage++;
        loadWhichData();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.view_load_recyclerview;
    }

    @Override
    public void onResponse(Call<FunsModel> call, Response<FunsModel> response) {
        String s=response.body().getShowapi_res_error();
        LogUtils.LOGD("funs-url---getShowapi_res_error--" + s);

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
    public void onFailure(Call<FunsModel> call, Throwable t) {

        onRefreshCallback(false);
        showConnectionRetry();
    }

    private void loadWhichData(){
        cmsAPI= RetrofitUtils.getRestAPI(Config.YiYuan_Url,CmsAPI.class);
        funsModelCall=cmsAPI.allFunes(mTag,"30576","05d26bb7715c48a1a156772da6d38106",
                "",String.valueOf(mPage),"10");
          if (funsModelCall!=null){
            funsModelCall.enqueue(this);
            LogUtils.LOGD("funs-url---" + funsModelCall.request().url());
        }
    }
}
