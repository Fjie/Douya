package me.fanjie.douya.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.fanjie.douya.R;
import me.fanjie.douya.controller.MyTest;
import me.fanjie.douya.model.User;

public class UserHomeActivity extends ChildActivity implements View.OnClickListener {

    private User user;

    private ImageView ivUserImage;
    private TextView tvUserName, tvUserResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        user = (User) getIntent().getSerializableExtra(ChildActivity.USER);
        setTitle(user.getUserName()+" 的主页");

        findViewById(R.id.btnUserPanel).setOnClickListener(this);
        findViewById(R.id.btnUserVideos).setOnClickListener(this);
        findViewById(R.id.btnLearnNowVideos).setOnClickListener(this);
        findViewById(R.id.btnUserPartys).setOnClickListener(this);
        findViewById(R.id.btnUserInterests).setOnClickListener(this);
        findViewById(R.id.btnAddFollow).setOnClickListener(this);


        ivUserImage = (ImageView) findViewById(R.id.ivUserImage);
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvUserResume = (TextView) findViewById(R.id.tvUserResume);

        MyTest.setHttpImage(ivUserImage, user.getUserImageUri());
        tvUserName.setText(user.getUserName());
        tvUserResume.setText(user.getUserResume());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_home, menu);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnUserPanel:
                new UserContentActivity().startChildActivity(this,user, ChildActivity.USER);
                break;
            case R.id.btnUserVideos:
                new ListActivity().startActivity(this,user.getUserName()+" 的视频",ListActivity.VIDEO_LIST);
                break;
            case R.id.btnLearnNowVideos:
                new ListActivity().startActivity(this,user.getUserName()+" 正在学习",ListActivity.VIDEO_LIST);
                break;
            case R.id.btnUserPartys:
                new ListActivity().startActivity(this, user.getUserName() + " 的活动", ListActivity.PARTY_LIST);
                break;
            case R.id.btnUserInterests:
                new UserInterestActivity().startChildActivity(this);
                break;
            case R.id.btnAddFollow:
                Toast.makeText(this,"添加关注成功!",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
