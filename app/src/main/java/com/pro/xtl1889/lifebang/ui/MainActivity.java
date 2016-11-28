package com.pro.xtl1889.lifebang.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

import com.pro.xtl1889.lifebang.R;

public class MainActivity extends TabActivity {
    private TabHost host;
    private TabHost.TabSpec tab1,tab2,tab3,tab4;
    private View view1,view2,view3,view4;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inflater=LayoutInflater.from(this);
        host=this.getTabHost();

        tab1=host.newTabSpec("tab1");   //创建选项卡其中的参数不是固定的，只是一个标志
        startActivity(R.layout.item_tab_home,tab1, view1, TabHomeActivity.class);

        tab2=host.newTabSpec("tab2");
        startActivity(R.layout.item_tab_live,tab2,view2,TabLiveActivity.class);

        tab3=host.newTabSpec("tab3");
        startActivity(R.layout.item_tab_vip,tab3,view3,TabVIPActivity.class);

        tab4=host.newTabSpec("tab4");
        startActivity(R.layout.item_tab_user, tab4, view4, TabUserActivity.class);

    }


    //测试提交

    private void startActivity(int resource,TabHost.TabSpec tab,View view,Class l) {
        view=inflater.inflate(resource, null);
        tab.setIndicator(view);  //设置标题
        Intent intent=new Intent(this, l);
        tab.setContent(intent);  //这是跳转内容
        host.addTab(tab);  //添加到host中
    }
}
