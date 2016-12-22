package com.pro.xtl1889.lifebang.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.LiveModel;
import com.pro.xtl1889.lifebang.ui.adapter.LiveAdapter;
import com.pro.xtl1889.lifebang.ui.base.BaseActivity;
import com.pro.xtl1889.lifebang.ui.pull2refresh.PullToRefreshLayout;
import com.pro.xtl1889.lifebang.ui.pull2refresh.PullableRecyclerView;
import com.pro.xtl1889.lifebang.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TabLiveActivity extends BaseActivity {

    @BindView(R.id.btn_go_back)
    ImageButton ivBut_back;
    @BindView(R.id.toolbar_title)
    TextView tv_title;
    @BindView(R.id.menu_edit)
    TextView tv_edit;

    @BindView(R.id.pull_to_refresh)
    PullToRefreshLayout pullRefresh_layout;
    @BindView(R.id.list)
    PullableRecyclerView mlistView;

    private LiveAdapter mLiveAdapter;
    private List<LiveModel> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_live);
        initView();
    }

    private void initView() {
        ivBut_back.setVisibility(View.GONE);
        tv_edit.setVisibility(View.GONE);
        tv_title.setText("休闲娱乐");
        pullRefresh_layout.setPullDownEnable(false);//禁止下拉
        pullRefresh_layout.setPullUpEnable(false);//禁止上拉

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplication(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        if (null==mLiveAdapter){
            mLiveAdapter=new LiveAdapter(this);
        }
        if (null!=mlistView){
            mlistView.setLayoutManager(gridLayoutManager);
            mlistView.setHasFixedSize(true);
            mlistView.setAdapter(mLiveAdapter);
            LogUtils.LOGD("-----live activity----1--");
        }

        getData();

    }

    private void getData(){
        mList=new ArrayList<>();
        LiveModel liveModel;
        for (int i = 0; i < 3; i++) {
            liveModel=new LiveModel();
            liveModel.setLiveTag(i);
            switch (i){
                case 0:
                    liveModel.setTitle("百度音乐");
//                    liveModel.setBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.qq_music));
                    liveModel.setId_iv(R.drawable.qq_music);
                    break;

                case 1:
                    liveModel.setTitle("百思不得姐");
//                    liveModel.setBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.no_sister));
                    liveModel.setId_iv(R.drawable.no_sister);
                    break;

                case 2:
                    liveModel.setTitle("笑话大全");
//                    liveModel.setBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.no_sister));
                    liveModel.setId_iv(R.drawable.funs);
                    break;
            }
            mList.add(liveModel);

        }

        if (null!=mLiveAdapter){
            mLiveAdapter.addItems(mList);
            LogUtils.LOGD("-----live activity---2---");
        }
    }
}
