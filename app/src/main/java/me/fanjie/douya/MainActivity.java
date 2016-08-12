package me.fanjie.douya;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import me.fanjie.douya.view.fragment.FeedsFragment;
import me.fanjie.douya.view.fragment.FindFragment;
import me.fanjie.douya.view.fragment.ListFragment;
import me.fanjie.douya.view.fragment.MineFragment;
import me.fanjie.douya.view.fragment.PartyFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemClickCallback,TabHost.OnTabChangeListener,PartyFragment.OnFragmentInteractionListener,FindFragment.OnFragmentInteractionListener,MineFragment.OnFragmentInteractionListener{

    private static final String TABSPEC_TAG_FEEDS = "feeds";
    private static final String TABSPEC_TAG_PARTY = "party";
    private static final String TABSPEC_TAG_FIND = "find";
    private static final String TABSPEC_TAG_MINE = "mine";
    private static final int REQUEST_VIDEO_CAPTURE = 9999;
    private TabHost host;
    private View feedsView, partyView, findView, mineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        host = (TabHost) findViewById(R.id.tabHost);
        host.setup();
        host.addTab(host.newTabSpec(TABSPEC_TAG_FEEDS).setIndicator(feedsView).setContent(R.id.feedsPanel));
        host.addTab(host.newTabSpec(TABSPEC_TAG_PARTY).setIndicator(partyView).setContent(R.id.partyPanel));
        host.addTab(host.newTabSpec(TABSPEC_TAG_FIND).setIndicator(findView).setContent(R.id.findPanel));
        host.addTab(host.newTabSpec(TABSPEC_TAG_MINE).setIndicator(mineView).setContent(R.id.minePanel));
        host.setCurrentTabByTag(this.TABSPEC_TAG_FEEDS);
        getSupportFragmentManager().beginTransaction().replace(R.id.feedsPanel,FeedsFragment.newInstance()).commit();
        host.setOnTabChangedListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_issue){
            Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if(i.resolveActivity(getPackageManager())!= null){
                startActivityForResult(i,REQUEST_VIDEO_CAPTURE);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView(){

        feedsView = getLayoutInflater().inflate(R.layout.layout_navigation_btn_feeds,null);
        partyView = getLayoutInflater().inflate(R.layout.layout_navigation_btn_party,null);
        findView = getLayoutInflater().inflate(R.layout.layout_navigation_btn_find,null);
        mineView = getLayoutInflater().inflate(R.layout.layout_navigation_btn_mine,null);
    }

    @Override
    public void onTabChanged(String tabId) {
        if (tabId.equals(this.TABSPEC_TAG_FEEDS)){
            getSupportFragmentManager().beginTransaction().replace(R.id.feedsPanel,FeedsFragment.newInstance()).commit();
        }
        if (tabId.equals(this.TABSPEC_TAG_PARTY)){
            getSupportFragmentManager().beginTransaction().replace(R.id.partyPanel,PartyFragment.newInstance("","")).commit();
        }
        if (tabId.equals(this.TABSPEC_TAG_FIND)){
            getSupportFragmentManager().beginTransaction().replace(R.id.findPanel, FindFragment.newInstance("","")).commit();
        }
        if (tabId.equals(this.TABSPEC_TAG_MINE)){
            getSupportFragmentManager().beginTransaction().replace(R.id.minePanel, MineFragment.newInstance("","")).commit();
        }

    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onItemClick(Object model) {

    }

    @Override
    public boolean onItemLongClick(Object model) {
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode ==REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK){
            Toast.makeText(this,"视频已经保存到本地",Toast.LENGTH_SHORT).show();
        }
    }
}
