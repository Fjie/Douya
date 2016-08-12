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
import me.fanjie.douya.model.Tip;

/**
 * Created by fanji on 2015/8/31.
 */
public class TipAdapter extends ListAdpter {

    public TipAdapter(Context context, List<?> models) {
        super(context, models);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tip tip = (Tip) getItem(position);
        View view;
        Holder holder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.layout_tip_list_item,null);
            holder = new Holder();
            holder.userImage = (ImageView) view.findViewById(R.id.userImage);
            holder.userName = (TextView) view.findViewById(R.id.userName);
            holder.tipContent = (TextView) view.findViewById(R.id.tipContent);
            holder.issueTime = (TextView) view.findViewById(R.id.issueTime);
            holder.likeCount = (TextView) view.findViewById(R.id.likeCount);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (Holder) view.getTag();
        }
        MyTest.setHttpImage(holder.userImage, tip.getWriter().getUserImageUri());
        holder.userName.setText(tip.getWriter().getUserName());
        holder.tipContent.setText(tip.getTipContent());
        holder.issueTime.setText(tip.getIssueTime());
        holder.likeCount.setText(tip.getLikeCount() + "赞");

        return view;
    }


    private class Holder{
        ImageView userImage;
        TextView userName,tipContent,issueTime,likeCount;
    }
}
