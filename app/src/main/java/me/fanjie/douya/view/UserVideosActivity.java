package me.fanjie.douya.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import me.fanjie.douya.R;
import me.fanjie.douya.controller.MyTest;
import me.fanjie.douya.model.Video;
import me.fanjie.douya.view.adapter.VideoAdapter;
import me.fanjie.douya.view.fragment.ListFragment;

public class UserVideosActivity extends ChildActivity implements ListFragment.ItemClickCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_videos);
        getSupportFragmentManager().beginTransaction().add(android.R.id.content,new ListFragment(new VideoAdapter(this, MyTest.getVideos()))).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hot_videos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(Object model) {
        Video video = (Video) model;
        new VideoContentActivity().startChildActivity(this, video, ChildActivity.VIDEO);
    }

    @Override
    public boolean onItemLongClick(Object model) {
        return false;
    }
}