package com.pro.xtl1889.lifebang.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.FunsItemModel;
import com.pro.xtl1889.lifebang.ui.base.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lianbinbo on 2017/1/11.
 */
public class FunsTextFunsAdapter extends BaseRecyclerAdapter<FunsItemModel> {
    public FunsTextFunsAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        viewHolder=new FunsTextViewHolder(LayoutInflater.from(mContext).inflate(R.layout.funs_text_layout,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FunsTextViewHolder funsTextViewHolder= (FunsTextViewHolder) holder;
        FunsItemModel funsItemModel=getItem(position);

        if (!TextUtils.isEmpty(funsItemModel.getTitle())){
            funsTextViewHolder.funs_text_title.setText(funsItemModel.getTitle());
        }
        if (!TextUtils.isEmpty(funsItemModel.getCt())){
            funsTextViewHolder.funs_text_time.setText(funsItemModel.getCt());
        }
        if (!TextUtils.isEmpty(funsItemModel.getText())){
            funsTextViewHolder.funs_text_text.setText(Html.fromHtml(funsItemModel.getText()));
        }

    }
    class FunsTextViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.funs_text_title)
        TextView funs_text_title;
        @BindView(R.id.funs_text_time)
        TextView funs_text_time;
        @BindView(R.id.funs_text_text)
        TextView funs_text_text;

        public FunsTextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
