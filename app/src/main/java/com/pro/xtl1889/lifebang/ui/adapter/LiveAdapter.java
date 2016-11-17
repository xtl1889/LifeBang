package com.pro.xtl1889.lifebang.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.LiveModel;
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LiveModel items=getItem(position);
        LiveViewHolder viewHolder= (LiveViewHolder) holder;
        LogUtils.LOGD("-----live adapter----1--");
        if (null!=items){
            viewHolder.iv.setImageResource(items.getId_iv());
            viewHolder.tv.setText(items.getTitle());
            LogUtils.LOGD("-----live adapter----2--");
        }

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
