package com.pro.xtl1889.lifebang.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.FunsItemModel;
import com.pro.xtl1889.lifebang.ui.base.BaseRecyclerAdapter;
import com.pro.xtl1889.lifebang.util.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lianbinbo on 2017/1/11.
 */
public class FunsImageFunsAdapter extends BaseRecyclerAdapter<FunsItemModel> {
    public FunsImageFunsAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        viewHolder=new FunsTextViewHolder(LayoutInflater.from(mContext).inflate(R.layout.funs_image_layout,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FunsTextViewHolder funsTextViewHolder= (FunsTextViewHolder) holder;
        FunsItemModel funsItemModel=getItem(position);

        if (!TextUtils.isEmpty(funsItemModel.getTitle())){
            funsTextViewHolder.funs_image_title.setText(funsItemModel.getTitle());
        }
        if (!TextUtils.isEmpty(funsItemModel.getImg())){
            LogUtils.LOGD("imageUrl----"+funsItemModel.getImg());
            funsTextViewHolder.funs_image_iv.setImageURI(funsItemModel.getImg());
        }
    }
    class FunsTextViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.funs_image_title)
        TextView funs_image_title;
       @BindView(R.id.funs_image_iv)
        SimpleDraweeView funs_image_iv;

        public FunsTextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
