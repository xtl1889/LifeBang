package com.pro.xtl1889.lifebang.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pro.xtl1889.lifebang.R;
import com.pro.xtl1889.lifebang.model.NoSisterContentlistBean;
import com.pro.xtl1889.lifebang.ui.base.BaseRecyclerAdapter;
import com.pro.xtl1889.lifebang.util.LogUtils;

import java.net.URI;
import java.net.URL;

/**
 * Created by lianbinbo on 2017/1/23.
 */
public class NoSisterAdapter extends BaseRecyclerAdapter<NoSisterContentlistBean> {

    private int type_tag=-1;
    private static int IMAGE_TYPE=0;//图片
    private static int TEXT_TYPE=1;//文本
    private static int VOICE_TYPE=2;//声音
    private static int VIDEO_TYPE=3;//视频
    public NoSisterAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemViewType(int position) {
        String type=getItem(position).getType();
        LogUtils.LOGD("noSister----Adapte---type----"+type+"----position----"+position+"--size---"+mItems.size());
        if ("10".equals(type)){
            type_tag=IMAGE_TYPE;
        }else if ("29".equals(type)){
            type_tag=TEXT_TYPE;
        }else if ("31".equals(type)){
        }else if ("41".equals(type)){
            type_tag=VIDEO_TYPE;
        }
        return type_tag;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LogUtils.LOGD("noSister------viewType-----"+viewType);
        RecyclerView.ViewHolder viewHolder=null;
        switch (viewType){
            case 0:
                viewHolder=new ImageHolder(LayoutInflater.from(mContext).inflate(R.layout.nosister_image_layout,parent,false));
                break;
            case 1:
                viewHolder=new TextHolder(LayoutInflater.from(mContext).inflate(R.layout.nosister_text_layout,parent,false));
                break;
            case 2:
                viewHolder=new VoiceHolder(LayoutInflater.from(mContext).inflate(R.layout.nosister_voice_layout,parent,false));
                break;
            case 3:
                viewHolder=new VideoHolder(LayoutInflater.from(mContext).inflate(R.layout.nosister_video_layout,parent,false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NoSisterContentlistBean noSisterContentlistBean=getItem(position);
        String name=noSisterContentlistBean.getName();//名字
        String time=noSisterContentlistBean.getCreate_time();//日期

        String profile_image=noSisterContentlistBean.getProfile_image();//头像
        String text =noSisterContentlistBean.getText();//文本描述   如果是段子 则表示段子正文

        String video_uri=noSisterContentlistBean.getVideo_uri();//视频播放地址
        String image0=noSisterContentlistBean.getImage0();//图片地址0
        String image1=noSisterContentlistBean.getImage1();//图片地址1
        String image2=noSisterContentlistBean.getImage2();//图片地址2
        String image3=noSisterContentlistBean.getImage3();//图片地址3

        String voice_uri=noSisterContentlistBean.getVoiceuri();//声音地址

        switch (getItemViewType(position)){
            case 0:
                ImageHolder imageHolder= (ImageHolder) holder;
                if (!TextUtils.isEmpty(text)){
                    imageHolder.nosister_image_title_tv.setText(text);
                }
                if (!TextUtils.isEmpty(name)){
                    imageHolder.nosister_image_name_tv.setText(name);
                }
                if (!TextUtils.isEmpty(time)){
                    imageHolder.nosister_image_time_tv.setText(time);
                }


                if (!TextUtils.isEmpty(image0)){
                    imageHolder.nosister_image_iv.setImageURI(image0);
                }
                break;
            case 1:
                TextHolder textHolder= (TextHolder) holder;
                if (!TextUtils.isEmpty(text)){
                    textHolder.nosister_text_title_tv.setText(text);
                    textHolder.nosister_text_tv.setText(text);
                }
                if (!TextUtils.isEmpty(name)){
                    textHolder.nosister_text_name_tv.setText(name);
                }
                if (!TextUtils.isEmpty(time)){
                    textHolder.nosister_text_time_tv.setText(time);
                }
                break;
            case 2:
                VoiceHolder voiceHolder= (VoiceHolder) holder;
                if (!TextUtils.isEmpty(text)){
                    voiceHolder.nosister_voice_title_tv.setText(text);
                }
                if (!TextUtils.isEmpty(name)){
                    voiceHolder.nosister_voice_name_tv.setText(name);
                }
                if (!TextUtils.isEmpty(time)){
                    voiceHolder.nosister_voice_time_tv.setText(time);
                }
                break;
            case 3:
                VideoHolder videoHolder= (VideoHolder) holder;
                if (!TextUtils.isEmpty(text)){
                    videoHolder.nosister_video_title_tv.setText(text);
                }
                if (!TextUtils.isEmpty(name)){
                    videoHolder.nosister_video_name_tv.setText(name);
                }
                if (!TextUtils.isEmpty(time)){
                    videoHolder.nosister_video_time_tv.setText(time);
                }
                break;
        }
    }

    class ImageHolder extends RecyclerView.ViewHolder{
        private ImageView nosister_image_title_iv;
        private TextView nosister_image_title_tv;
        private TextView nosister_image_name_tv;
        private TextView nosister_image_time_tv;
        private SimpleDraweeView nosister_image_iv;
        public ImageHolder(View itemView) {
            super(itemView);
            nosister_image_title_iv= (ImageView) itemView.findViewById(R.id.nosister_image_title_iv);
            nosister_image_title_tv= (TextView) itemView.findViewById(R.id.nosister_image_title_tv);
            nosister_image_name_tv= (TextView) itemView.findViewById(R.id.nosister_image_name_tv);
            nosister_image_time_tv= (TextView) itemView.findViewById(R.id.nosister_image_time_tv);
            nosister_image_iv= (SimpleDraweeView) itemView.findViewById(R.id.nosister_image_iv);
        }
    }

    class TextHolder extends RecyclerView.ViewHolder{
        private ImageView nosister_text_title_iv;
        private TextView nosister_text_title_tv;
        private TextView nosister_text_name_tv;
        private TextView nosister_text_time_tv;
        private TextView nosister_text_tv;
        public TextHolder(View itemView) {
            super(itemView);
            nosister_text_title_iv= (ImageView) itemView.findViewById(R.id.nosister_text_title_iv);
            nosister_text_title_tv= (TextView) itemView.findViewById(R.id.nosister_text_title_tv);
            nosister_text_name_tv= (TextView) itemView.findViewById(R.id.nosister_text_name_tv);
            nosister_text_time_tv= (TextView) itemView.findViewById(R.id.nosister_text_time_tv);
            nosister_text_tv= (TextView) itemView.findViewById(R.id.nosister_text_tv);
        }
    }

    class VoiceHolder extends RecyclerView.ViewHolder{

        private ImageView nosister_voice_title_iv;
        private TextView nosister_voice_title_tv;
        private TextView nosister_voice_name_tv;
        private TextView nosister_voice_time_tv;
        private ImageView nosister_voice_iv;
        public VoiceHolder(View itemView) {
            super(itemView);
            nosister_voice_title_iv= (ImageView) itemView.findViewById(R.id.nosister_voice_title_iv);
            nosister_voice_title_tv= (TextView) itemView.findViewById(R.id.nosister_voice_title_tv);
            nosister_voice_name_tv= (TextView) itemView.findViewById(R.id.nosister_voice_name_tv);
            nosister_voice_time_tv= (TextView) itemView.findViewById(R.id.nosister_voice_time_tv);
            nosister_voice_iv= (ImageView) itemView.findViewById(R.id.nosister_voice_iv);
        }
    }

    class VideoHolder extends RecyclerView.ViewHolder{

        private ImageView nosister_video_title_iv;
        private TextView nosister_video_title_tv;
        private TextView nosister_video_name_tv;
        private TextView nosister_video_time_tv;
        private ImageView nosister_video_iv;
        public VideoHolder(View itemView) {
            super(itemView);
            nosister_video_title_iv= (ImageView) itemView.findViewById(R.id.nosister_video_title_iv);
            nosister_video_title_tv= (TextView) itemView.findViewById(R.id.nosister_video_title_tv);
            nosister_video_name_tv= (TextView) itemView.findViewById(R.id.nosister_video_name_tv);
            nosister_video_time_tv= (TextView) itemView.findViewById(R.id.nosister_video_time_tv);
            nosister_video_iv= (ImageView) itemView.findViewById(R.id.nosister_video_iv);
        }
    }
}
