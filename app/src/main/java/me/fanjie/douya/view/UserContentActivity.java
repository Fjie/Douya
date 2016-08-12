package me.fanjie.douya.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import me.fanjie.douya.R;
import me.fanjie.douya.controller.MyTest;
import me.fanjie.douya.model.User;

public class UserContentActivity extends ChildActivity {

    private User user;

    private ImageView myImage;
    private TextView myName,mySex,myResume,myCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_content);

        user = (User) getIntent().getSerializableExtra(ChildActivity.USER);
        setTitle(user.getUserName());

        myImage = (ImageView) findViewById(R.id.myImage);
        myName = (TextView) findViewById(R.id.myName);
        mySex = (TextView) findViewById(R.id.mySex);
        myResume = (TextView) findViewById(R.id.myResume);
        myCity = (TextView) findViewById(R.id.myCity);

        MyTest.setHttpImage(myImage, user.getUserImageUri());
        myName.setText(user.getUserName());
        mySex.setText(user.getSex());
        myResume.setText(user.getUserResume());
        myCity.setText(user.getCity());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_content, menu);
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
}
