package me.fanjie.douya.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import me.fanjie.douya.R;
import me.fanjie.douya.controller.MyTest;
import me.fanjie.douya.model.Video;
import me.fanjie.douya.view.ChildActivity;
import me.fanjie.douya.view.VideoContentActivity;
import me.fanjie.douya.view.adapter.VideoAdapter;

public class FeedsFragment extends Fragment implements AdapterView.OnItemClickListener {

    private List<Video> videos;

    public static FeedsFragment newInstance() {
        FeedsFragment fragment = new FeedsFragment();
        return fragment;
    }

    public FeedsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView listView  = (ListView) inflater.inflate(R.layout.fragment_feeds, container, false);
        videos = MyTest.getVideos();
        listView.setAdapter(new VideoAdapter(getActivity(),videos));
        listView.setOnItemClickListener(this);
        return listView;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        new VideoContentActivity().startChildActivity(getActivity(),videos.get(position), ChildActivity.VIDEO);
    }
}
