package me.fanjie.douya.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.fanjie.douya.R;
import me.fanjie.douya.controller.MyTest;
import me.fanjie.douya.model.Video;

/**
 * Created by fanji on 2015/8/23.
 */
public class VideoAdapter extends ListAdpter {

    private Video video;

    public VideoAdapter(Context context, List<?> models) {
        super(context, models);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        video = (Video) getItem(position);
        View view;
        Holder holder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.layout_video_list_item,null);
            holder = new Holder();
            holder.ivVideoImage = (ImageView) view.findViewById(R.id.ivVideoImage);
            holder.tvVideoTitle = (TextView) view.findViewById(R.id.tvVideoTitle);
            holder.tvPlayCount = (TextView) view.findViewById(R.id.tvPlayCount);
            holder.tvVideoLength = (TextView) view.findViewById(R.id.tvVideoLength);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (Holder) view.getTag();
        }
        MyTest.setHttpImage(holder.ivVideoImage,video.getVideoImageUri());
        holder.tvVideoTitle.setText(video.getVideoTitle());
        holder.tvPlayCount.setText(video.getPlayCount()+"次播放");
        holder.tvVideoLength.setText(video.getVideoLength());

        return view;
    }

    private class Holder{
        ImageView ivVideoImage;
        TextView tvVideoTitle,tvPlayCount,tvVideoLength;
    }

}
