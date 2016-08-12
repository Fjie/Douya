package me.fanjie.douya.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import me.fanjie.douya.R;
import me.fanjie.douya.controller.MyTest;
import me.fanjie.douya.model.Video;
import me.fanjie.douya.view.adapter.VideoAdapter;

public class ListActivity extends ChildActivity implements AdapterView.OnItemClickListener {

    private static final String TYPE = "type";
    private static final String TITLE = "title";
    public final static int VIDEO_LIST = 99999;
    public final static int USER_LIST = 55555;
    public final static int PARTY_LIST = 11111;

    private ListView listView;
    private List<?> list;
    private int type;

    public void startActivity(Activity context,String title,int type) {
        Intent i = new Intent(context,getClass());
        i.putExtra(TITLE,title);
        i.putExtra(TYPE,type);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle(getIntent().getStringExtra(TITLE));
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

        switch (getIntent().getIntExtra(TYPE,0)){
            case VIDEO_LIST:
                type = VIDEO_LIST;
                list = MyTest.getVideos();
                listView.setAdapter(new VideoAdapter(this,list));
                break;
            case USER_LIST:
                type = USER_LIST;
                break;
            case PARTY_LIST:
                type = PARTY_LIST;
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (type){
            case VIDEO_LIST:
                Video video = (Video) list.get(position);
                new VideoContentActivity().startChildActivity(this,video,ChildActivity.VIDEO);
                break;
        }
    }
}
