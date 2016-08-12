package me.fanjie.douya.view.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fanji on 2015/8/23.
 */
public abstract class ListAdpter extends BaseAdapter implements Serializable{

    private Context context;

    private List<?> models;

    public ListAdpter(Context context,List<?> models){
        super();
        this.context = context;
        this.models = models;
    }


    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Context getContext() {
        return context;
    }
}
