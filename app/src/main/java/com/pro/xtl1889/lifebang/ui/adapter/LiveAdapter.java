package com.pro.xtl1889.lifebang.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.LiveModel;
import com.pro.xtl1889.lifebang.ui.FunsActivity;
import com.pro.xtl1889.lifebang.ui.NoSisterActivity;
import com.pro.xtl1889.lifebang.ui.base.BaseRecyclerAdapter;
import com.pro.xtl1889.lifebang.util.DeviceUtils;
import com.pro.xtl1889.lifebang.util.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xtl1889 on 16-9-3.
 */
public class LiveAdapter extends BaseRecyclerAdapter<LiveModel> {
    public LiveAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_live,parent,false);
        RecyclerView.LayoutParams lp= (RecyclerView.LayoutParams) view.getLayoutParams();
        lp.setMargins(5,0,5,0);
        lp.height= (int) (DeviceUtils.getScreenWidth(mContext)/2*0.8);

        return new LiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        LiveModel items=getItem(position);
        LiveViewHolder viewHolder= (LiveViewHolder) holder;
        if (null!=items){
            viewHolder.iv.setImageResource(items.getId_iv());
            viewHolder.tv.setText(items.getTitle());
            LogUtils.LOGD("-----live adapter----2--");
        }

        viewHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==2){//跳转到笑话大全
                   mContext.startActivity(new Intent(mContext, FunsActivity.class));
                }else if (position==1){//跳转到百思不得姐
                    mContext.startActivity(new Intent(mContext, NoSisterActivity.class));
                }else if (position==0){

                }
//                Toast.makeText(mContext,"跳转想起页面",Toast.LENGTH_SHORT).show();
            }
        });
    }
    class LiveViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img_room)
        SimpleDraweeView iv;
        @BindView(R.id.tv_anchor_title)
        TextView tv;
        public LiveViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
