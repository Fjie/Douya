package me.fanjie.douya.view;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.List;

import me.fanjie.douya.R;
import me.fanjie.douya.controller.MyTest;
import me.fanjie.douya.model.User;
import me.fanjie.douya.model.Video;
import me.fanjie.douya.view.adapter.TipAdapter;
import me.fanjie.douya.view.adapter.VideoAdapter;

public class VideoContentActivity extends ChildActivity implements AdapterView.OnItemClickListener {

    private static final String TAB_INTRODUCTION = "introduction";
    private static final String TAB_TIPS = "likeness";
    private static final String TAB_LIKENESS = "likeness";

    private Video video;
    private List<Video> likenessVideos;

    private TabHost host;
    private TextView videoTitle;
    private ListView tipList,likenessList;
    private VideoView videoView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_content);
        video = (Video) getIntent().getSerializableExtra(ChildActivity.VIDEO);
        likenessVideos = MyTest.getVideos();
        initHost();
        initActivity();
    }

    private void initActivity() {
        videoTitle = (TextView) findViewById(R.id.videoTitle);
        tipList = (ListView) findViewById(R.id.tabTips);
        likenessList= (ListView) findViewById(R.id.tabLikeness);
        videoView = (VideoView) findViewById(R.id.videoView);
        linearLayout = (LinearLayout) findViewById(R.id.relativeLayout);

        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(Uri.parse(video.getDataUri()));
        videoTitle.setText(video.getVideoTitle());
        likenessList.setAdapter(new VideoAdapter(this, likenessVideos));
        tipList.setAdapter(new TipAdapter(this,video.getTips()));

        likenessList.setOnItemClickListener(this);
        tipList.setOnItemClickListener(this);
    }

    private void initHost() {
        host = (TabHost) findViewById(R.id.tabHost);
        host.setup();
        host.addTab(host.newTabSpec(TAB_INTRODUCTION).setIndicator(getString(R.string.video_content_tab_title_introduction)).setContent(R.id.tabIntroduction));
        host.addTab(host.newTabSpec(TAB_TIPS).setIndicator(getString(R.string.vidoe_content_tab_title_tips)).setContent(R.id.tabTips));
        host.addTab(host.newTabSpec(TAB_LIKENESS).setIndicator(getString(R.string.vidoe_content_tab_title_likeness)).setContent(R.id.tabLikeness));
        host.setCurrentTabByTag(TAB_INTRODUCTION);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_video_content,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_download){
            DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
            downloadManager.enqueue(new DownloadManager.Request(Uri.parse(video.getDataUri())));
            return true;
        }
        if (id == R.id.action_share){
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT,"分享个毛片"+video.getDataUri());
            startActivity(i);
            return true;
        }
        if (id == R.id.action_add_to_learn){
            Toast.makeText(this,"添加到学习列表",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.tabLikeness){
            new VideoContentActivity().startChildActivity(this,likenessVideos.get(position),ChildActivity.VIDEO);
        }
        if (parent.getId() == R.id.tabTips){
            final User user = video.getTips().get(position).getWriter();
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setItems(R.array.on_tip_list_item_click_do, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case 0:

                            break;
                        case 1:

                            break;
                        case 2:
                            new UserHomeActivity().startChildActivity(VideoContentActivity.this, user, ChildActivity.USER);
                            break;
                        case 3:

                            break;

                    }
                }
            });
            builder.show();
        }
    }
}
