package com.pro.xtl1889.lifebang.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.ui.MainActivity;

import java.util.List;

/**
 * Created by zuoxian on 15/10/30.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<View> views;
    private Activity activity;

    public ViewPagerAdapter(List<View> views, Activity activity) {
        this.views = views;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(views.get(arg1), 0);
        if (arg1 == views.size() - 1) {
            ImageView endImage = (ImageView) arg0
                    .findViewById(R.id.img3);
            endImage.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 设置已经引导
                    goHome();

                }

            });
        }
        return views.get(arg1);
    }
    private void goHome() {
        // 跳转
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

//    private void setGuided() {
//        SharedPreferences preferences = activity.getSharedPreferences(
//                SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        // 存入数据
//        editor.putBoolean("isFirstIn", false);
//        // 提交修改
//        editor.commit();
//    }


    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }
}
