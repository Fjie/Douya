package me.fanjie.douya.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.io.Serializable;

/**
 * Created by fanji on 2015/8/16.
 */
public class ChildActivity extends AppCompatActivity {

    public static final String USER = "user";
    public static final String VIDEO = "video";


    private ActionBar bar;

    public void startChildActivity(Activity context){
        Intent i = new Intent(context, getClass());
        context.startActivity(i);
    }
    public void startChildActivity(Activity context, Serializable arg, String serializableTag){
        Intent i = new Intent(context, getClass());
        if(arg!=null) {
            i.putExtra(serializableTag, arg);
        }
        context.startActivity(i);
    }
    public void startChildActivity(Activity context, Bundle bundle){
        Intent i = new Intent(context, getClass());
        if(bundle!=null){
            i.putExtras(bundle);
        }
        context.startActivity(i);
    }
    public void startChildActivity(Activity context,int requestCode){
        Intent i = new Intent(context, getClass());
        context.startActivityForResult(i, requestCode);
    }
    public void startChildActivity(Activity context,Serializable arg, String serializableTag,int requestCode){
        Intent i = new Intent(context, getClass());
        if(arg!=null) {
            i.putExtra(serializableTag, arg);
        }
        context.startActivityForResult(i,requestCode);
    }
    public void startChildActivity(Activity context,Bundle bundle, int requestCode){
        Intent i = new Intent(context, getClass());
        if(bundle!=null) {
            i.putExtra("xxx", bundle);
        }
        context.startActivityForResult(i,requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
