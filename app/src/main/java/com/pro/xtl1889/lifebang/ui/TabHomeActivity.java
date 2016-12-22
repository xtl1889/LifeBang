package com.pro.xtl1889.lifebang.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.pro.xtl1889.lifebang.Config;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.api.CmsAPI;
import com.pro.xtl1889.lifebang.model.Cs;
import com.pro.xtl1889.lifebang.model.NewFragmentModel;
import com.pro.xtl1889.lifebang.ui.adapter.TabHome_viewpagerAdapter;
import com.pro.xtl1889.lifebang.ui.base.BaseActivity;
import com.pro.xtl1889.lifebang.ui.fragment.NewsFragment;
import com.pro.xtl1889.lifebang.util.LogUtils;
import com.pro.xtl1889.lifebang.util.RetrofitUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabHomeActivity extends BaseActivity {


    @BindView(R.id.id_tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.id_viewpager)
    ViewPager mViewPager;
    private List<NewFragmentModel> mList;
    private TabHome_viewpagerAdapter mViewpagerAdapter;

    private CmsAPI cmsAPI,cmsAPI1;

    String[] titleString={"国际新闻","科技新闻","健康生活","体育新闻","娱乐花边"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(TabHomeActivity.this);//初始化Fresco
        setContentView(R.layout.activity_tab_home);
        initView();
        initView2();
    }

    private void initView() {
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tab_bottom_text_seletor));
        mTabLayout.setTabTextColors(R.color.grid_lines,R.color.tab_bottom_text_seletor);

        mList=new ArrayList<>();
        NewFragmentModel fragmentModel;
        NewsFragment newFragment;
        String title = null;
        for (int i = 0; i < titleString.length; i++) {
            title=titleString[i];
            newFragment=new NewsFragment(this,i);
            fragmentModel=new NewFragmentModel(title,newFragment);
            mList.add(fragmentModel);
        }

        mViewpagerAdapter=new TabHome_viewpagerAdapter(getSupportFragmentManager(),TabHomeActivity.this,mList);
        mViewPager.setOffscreenPageLimit(mList.size());//指定ViewPager缓存Fragment的个数
        mViewPager.setAdapter(mViewpagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i <mTabLayout.getTabCount() ; i++) {
            TabLayout.Tab tabAt=mTabLayout.getTabAt(i);
            tabAt.setCustomView(mViewpagerAdapter.getView(i));
        }

        mViewpagerAdapter.notifyDataSetChanged();
    }


    private void initView2() {//该方法用来测试 接口
        cmsAPI= RetrofitUtils.getRestAPI(Config.LXH_URL, CmsAPI.class);
        cmsAPI1=RetrofitUtils.getRestAPI(Config.BaiDu_Url,CmsAPI.class);

        Call<Cs> call=cmsAPI.csDatsa();
        call.enqueue(new Callback<Cs>() {
            @Override
            public void onResponse(Call<Cs> call, Response<Cs> response) {
                LogUtils.LOGD("----cs----cg--" + response.body().getDefaultt());
                LogUtils.LOGD("----cs----cgurl--" + call.request().url());//请求的地址

//                tv.setText(response.body().getDefaultt()+"");
            }

            @Override
            public void onFailure(Call<Cs> call, Throwable t) {
                LogUtils.LOGD("----cs----sb--"+call.toString());
            }
        });

        Call<ResponseBody> call1=cmsAPI1.Cheshi("10", "1");
        call1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String s=response.body().string();
                    LogUtils.LOGD("------------baidu-Cheshi--"+s);
                    LogUtils.LOGD("------------baidu-Cheshi-url--"+call.request().url());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                LogUtils.LOGD("------------baidu-Cheshi-url-"+call.request().url());
            }
        });
    }
}
