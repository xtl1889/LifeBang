package com.pro.xtl1889.lifebang.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.TextView;

import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.NewFragmentModel;

import java.util.List;

/**
 * Created by xtl1889 on 16-8-22.
 */
public class TabHome_viewpagerAdapter extends FragmentPagerAdapter {
    private List<NewFragmentModel> mListFragmentModel;
    private Context mContext;
    public TabHome_viewpagerAdapter(FragmentManager fm,Context mContext,List mListFragmentModel) {
        super(fm);
        this.mContext=mContext;
        this.mListFragmentModel=mListFragmentModel;
    }


    @Override
    public Fragment getItem(int position) {
        return mListFragmentModel.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mListFragmentModel.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mListFragmentModel.get(position).getTag();
    }

    public View getView(int i){
        View view=View.inflate(mContext,R.layout.view_tablaout,null);
        TextView tv= (TextView) view.findViewById(R.id.txt_title);
//        SimpleDraweeView img= (SimpleDraweeView) view.findViewById(R.id.img_logo);

        tv.setText(mListFragmentModel.get(i).getTag());

        return view;
    }
}
