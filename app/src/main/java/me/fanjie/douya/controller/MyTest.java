package me.fanjie.douya.controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.fanjie.douya.model.Tip;
import me.fanjie.douya.model.User;
import me.fanjie.douya.model.Video;

/**
 * Created by fanji on 2015/8/17.
 */
public class MyTest {

    public static final int MSG_WHAT = 0x123;
    public static final String TAG = "MyTest";
    public static final int MAX_LIST_LENGTH = 10;

    public static List<Video> getVideos(){
        List<Video> videos = new ArrayList<>();
        for (int i = 0; i < MAX_LIST_LENGTH; i++) {
            videos.add(new Video(titleString[getRandomNumber(titleString.length)],videoLength[getRandomNumber(videoLength.length)],getRandomNumber(1000),videoImageUri[getRandomNumber(videoImageUri.length)],getUser(),getTips(),videoDataUri[getRandomNumber(videoDataUri.length)]));
        }
        return videos;
    }

    public static List<Tip> getTips(){
        List<Tip> tips = new ArrayList<>();
        for (int i = 0; i < MAX_LIST_LENGTH; i++) {
            tips.add(new Tip(getUser(), contentString[getRandomNumber(contentString.length)], date[getRandomNumber(date.length)], getRandomNumber(500)));
        }
        return tips;
    }

    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < MAX_LIST_LENGTH; i++) {
            users.add(new User(nameString[getRandomNumber(nameString.length)], contentString[getRandomNumber(contentString.length)], userImageUri[getRandomNumber(userImageUri.length)], sex[getRandomNumber(sex.length)], city[getRandomNumber(city.length)]));
        }
        return users;
    }

    public static User getUser(){
        return getUsers().get(getRandomNumber(getUsers().size()));
    }






    private static String[] nameString = {
            "装笔筒子",
            "后知后觉",
            "萨嘎",
            "不想哭的鱼",
            "朱萧木",
            "偏执狂,我只触过奇迹的手",
            "装笔筒子",
            "zhiayumi",
            "爬树",
    };
    private static String[] titleString = {
            "进击的巨人真人版",
            "花与爱丽丝杀人事件",
            "小男孩",
            "小森林",
            "头脑特工队",
            "深夜食堂",
            "百元之恋",
            "杀破狼2",
            "可爱的你",

    };
    private static String[] contentString = {
            "一直在牛逼，从未被超越。只有Nolan才能达到这种境界！！！",
            "迷离失所，戏假情真！",
            "概念不算新鲜但还不错 ;p 充斥许多漂亮的慢动作镜头和带点匪夷所思的建筑构想，视觉效果挺棒的！偶尔会令我想起Paprika……",
            "列奥纳多干完这票肯定是要去Shutter Island修养一阵了。",
            "一部电影好看到即使你明白它在故弄玄虚也是义无反顾的打五星。",
            "我的陀螺停不下来了。",
            "植入意识不向来是我泱泱大国的长项么？",
            "看到“诺兰出品”四个字，也就不用怀疑质量了",
            "前期的口碑营销确实有点儿过了，绝对还没有达到神作的级别，但依旧是近年来最好的影片，诺兰独有的叙事技巧视觉风格以及影像语言都被完美的贯彻其中",
    };

    private static String[] sex = {
            "男",
            "女",
            "变态",
    };

    private static String[] city = {
            "山东潍坊",
            "广东东莞",
            "江苏苏州",
            "广东佛山",
            "江苏无锡",
            "广东珠海",
            "广东中山",
            "浙江舟山",
            "浙江温州",
            "江苏常州",
    };

    private static String[] videoLength = {
            getRandomNumber(60)+":"+getRandomNumber(60),
            getRandomNumber(60)+":"+getRandomNumber(60),
            getRandomNumber(60)+":"+getRandomNumber(60),
            getRandomNumber(60)+":"+getRandomNumber(60),
            getRandomNumber(60)+":"+getRandomNumber(60),
            getRandomNumber(60)+":"+getRandomNumber(60),
            getRandomNumber(60)+":"+getRandomNumber(60),
            getRandomNumber(60)+":"+getRandomNumber(60),
            getRandomNumber(60)+":"+getRandomNumber(60),

    };

    private static String[] userImageUri = {
            "http://img1.imgtn.bdimg.com/it/u=45740917,910344312&fm=23&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=3203914403,442375717&fm=23&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3955874614,4177011805&fm=23&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=991420037,3601799833&fm=23&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1330185636,938896845&fm=23&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1309371427,270561068&fm=23&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1220568945,2821416677&fm=23&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=22369829,1417657170&fm=23&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=318387991,4004592930&fm=23&gp=0.jpg",

    };

    private static String[] videoImageUri = {
            "http://img4.imgtn.bdimg.com/it/u=1049181026,2769790430&fm=23&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=3191852070,1317968058&fm=23&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1021612463,3505825772&fm=23&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2002046933,3385073271&fm=23&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2545788560,1156182356&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=614379225,935450557&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=3419574908,2628270983&fm=21&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3323666586,515331499&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=3018125194,2856205725&fm=21&gp=0.jpg",

    };

    private static String[] videoDataUri = {
            "http://mp4.888mp4.com/new/dm/2015-09/0902/mnrg.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0831/lrcb.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0830/lmjh.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0829/ljjlb3.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0828/ljjlb1.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0827/lazdz.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0827/kuhjmgfb.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0826/kmnb.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0825/khjbv.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0826/kmnjg.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0823/jlgzsbt1.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0823/jrntz.mp4",
            "http://mp4.888mp4.com/new/dm/2015-08/0824/jyzj.mp4",
            "http://mp4.888mp4.com/jp/201507/0715/yyk.mp4",

    };

    private static String[] date = {
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
        getRandomNumber(12)+"月"+getRandomNumber(30)+"日",
    };





    public static int getRandomNumber(int max){
        return Math.abs(new Random().nextInt(max));
    }

    public static void setHttpImage(final ImageView v, final String url){

        final Bitmap[] b = new Bitmap[1];

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == MSG_WHAT){
                    v.setImageBitmap(b[0]);
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                try {
                    b[0] = BitmapFactory.decodeStream(new URL(url).openStream());
                    handler.sendEmptyMessage(MSG_WHAT);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public static void downLoadMp4(final String url){
        Log.e(TAG,url);
        new Thread(){
            @Override
            public void run() {
                try {
                    File file = new File("/xxxx.mp4");
                    Log.e(TAG,"run");
                    BufferedInputStream bis = new BufferedInputStream(new URL(url).openStream());
                    Log.e(TAG,"read");
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                    Log.e(TAG,"write");

                    byte[] b = new byte[50*1024];
                    Log.e(TAG,b.toString());

                    while ((bis.read(b))!=-1){
                        bos.write(b);
                        Log.e(TAG,b.toString());
                    }
                    bos.flush();
                    bos.close();
                    bis.close();

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG,"catch");

                }
            }
        }.start();
    }




}
