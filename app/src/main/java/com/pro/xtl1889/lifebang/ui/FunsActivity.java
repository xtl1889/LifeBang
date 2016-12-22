package com.pro.xtl1889.lifebang.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.NewFragmentModel;
import com.pro.xtl1889.lifebang.ui.adapter.TabHome_viewpagerAdapter;
import com.pro.xtl1889.lifebang.ui.base.BaseActivity;
import com.pro.xtl1889.lifebang.ui.fragment.FunsFragment;
import com.pro.xtl1889.lifebang.ui.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/*
* 笑话大全
* */
public class FunsActivity extends BaseActivity  {

    @BindView(R.id.funsTablayout)
    TabLayout funsTablayout;
    @BindView(R.id.funsViewPager)
    ViewPager funsViewPager;

    private List<NewFragmentModel> mList;
    private TabHome_viewpagerAdapter mViewpagerAdapter;
    String[] titleString={"文本","图片","动态图"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funs);

        initView();
    }

    private void initView() {

        funsTablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tab_bottom_text_seletor));
        funsTablayout.setTabTextColors(R.color.grid_lines,R.color.tab_bottom_text_seletor);

        mList=new ArrayList<>();
        NewFragmentModel fragmentModel;
        FunsFragment funsFragment;
        String title = null;
        for (int i = 0; i < titleString.length; i++) {
            title=titleString[i];
            funsFragment=new FunsFragment(this,i);
            fragmentModel=new NewFragmentModel(title,funsFragment);
            mList.add(fragmentModel);
        }

        mViewpagerAdapter=new TabHome_viewpagerAdapter(getSupportFragmentManager(),FunsActivity.this,mList);
        funsViewPager.setOffscreenPageLimit(mList.size());//指定ViewPager缓存Fragment的个数
        funsViewPager.setAdapter(mViewpagerAdapter);

        funsTablayout.setupWithViewPager(funsViewPager);

        for (int i = 0; i <funsTablayout.getTabCount() ; i++) {
            TabLayout.Tab tabAt=funsTablayout.getTabAt(i);
            tabAt.setCustomView(mViewpagerAdapter.getView(i));
        }

        mViewpagerAdapter.notifyDataSetChanged();
    }
}
