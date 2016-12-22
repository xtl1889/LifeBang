package com.pro.xtl1889.lifebang.ui.fragment;

import android.content.Context;

import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.FunsModel;
import com.pro.xtl1889.lifebang.ui.base.BaseLoadFragment;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lianbinbo on 2016/12/22.
 */
public class FunsFragment extends BaseLoadFragment<FunsModel> {
    private Context mContext;
    private int tag;//标记   加载那种内容

    public FunsFragment(Context mContext, int tag) {
        this.mContext = mContext;
        this.tag = tag;
    }

    @Override
    protected void onLoadData() {

    }

    @Override
    protected void onInitLoadData(FunsModel pageData) {

    }

    @Override
    protected void judgePage() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.funs_fragment_layout;
    }

    @Override
    public void onResponse(Call<FunsModel> call, Response<FunsModel> response) {

    }

    @Override
    public void onFailure(Call<FunsModel> call, Throwable t) {

    }
}
