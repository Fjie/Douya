package me.fanjie.douya.view.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import me.fanjie.douya.R;
import me.fanjie.douya.view.adapter.ListAdpter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListAdpter adpter;
    private ListView listView;

    private ItemClickCallback callback;

    /**
     * @param adpter
     */
    public ListFragment(ListAdpter adpter) {
        this.adpter = adpter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callback = (ItemClickCallback) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        callback.onItemClick(adpter.getItem(position));
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return callback.onItemLongClick(adpter.getItem(position));
    }

    public interface ItemClickCallback{
        public void onItemClick(Object model);
        public boolean onItemLongClick(Object model);
    }
}
