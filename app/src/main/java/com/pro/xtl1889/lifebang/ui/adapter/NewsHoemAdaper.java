package com.pro.xtl1889.lifebang.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.NewslistBean;
import com.pro.xtl1889.lifebang.ui.NewsDetailedActivity;
import com.pro.xtl1889.lifebang.ui.base.BaseRecyclerAdapter;
import com.pro.xtl1889.lifebang.util.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xtl1889 on 16-8-23.
 */
public class NewsHoemAdaper extends BaseRecyclerAdapter<NewslistBean> {

//    private Context mContext;
    public NewsHoemAdaper(Context context) {
        super(context);
//        this.mContext=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        viewHolder=new NewsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final NewslistBean newslistBean=getItem(position);
        NewsViewHolder viewHolder= (NewsViewHolder) holder;

        LogUtils.LOGD("------------baidu-adapter--size" + getList());

        if (!TextUtils.isEmpty(newslistBean.getTitle())){
            viewHolder.tv_title.setText(newslistBean.getTitle());
        }

        if (!TextUtils.isEmpty(newslistBean.getCtime())){
            viewHolder.tv_time.setText(newslistBean.getCtime());
        }

        if (!TextUtils.isEmpty(newslistBean.getPicUrl())){
            viewHolder.iv.setImageURI(newslistBean.getPicUrl());
        }

        if (!TextUtils.isEmpty(newslistBean.getDescription())){
            viewHolder.tv_from.setText("来自："+newslistBean.getDescription());
        }

        viewHolder.news_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(newslistBean.getUrl())){
                    Intent intent=new Intent(mContext, NewsDetailedActivity.class);
                    intent.putExtra("newUrl",newslistBean.getUrl());
                    mContext.startActivity(intent);
                }else {
                    Toast.makeText(mContext,"暂无数据",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.news_item)
        RelativeLayout news_item;

        @BindView(R.id.news_item_iv)
        SimpleDraweeView iv;
        @BindView(R.id.news_item_title)
        TextView tv_title;
        @BindView(R.id.news_item_time)
        TextView tv_time;
        @BindView(R.id.news_item_from)
        TextView tv_from;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
