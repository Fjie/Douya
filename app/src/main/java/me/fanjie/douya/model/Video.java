package me.fanjie.douya.model;

import java.util.List;

/**
 * Created by fanji on 2015/8/16.
 */
public class Video implements ModelInterface {

    private String videoTitle;
    private String videoLength;
    private int playCount = 0;

    private String videoImageUri;

    private User author;

    private List<Tip> tips;
    private List<Video> resembleVideos;

    private String dataUri;

    public Video(String videoTitle, String videoLength, int playCount, String videoImageUri) {
        this.videoTitle = videoTitle;
        this.videoLength = videoLength;
        this.playCount = playCount;
        this.videoImageUri = videoImageUri;
    }

    public Video(String videoTitle, String videoLength, int playCount, String videoImageUri, User author, List<Tip> tips) {
        this.videoTitle = videoTitle;
        this.videoLength = videoLength;
        this.playCount = playCount;
        this.videoImageUri = videoImageUri;
        this.author = author;
        this.tips = tips;
    }
    public Video(String videoTitle, String videoLength, int playCount, String videoImageUri, User author, List<Tip> tips,String dataUri) {
        this.videoTitle = videoTitle;
        this.videoLength = videoLength;
        this.playCount = playCount;
        this.videoImageUri = videoImageUri;
        this.author = author;
        this.tips = tips;
        this.dataUri = dataUri;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public void setVideoLength(String videoLength) {
        this.videoLength = videoLength;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public void setVideoImageUri(String videoImageUri) {
        this.videoImageUri = videoImageUri;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setTips(List<Tip> tips) {
        this.tips = tips;
    }

    public void setResembleVideos(List<Video> resembleVideos) {
        this.resembleVideos = resembleVideos;
    }

    public void setDataUri(String dataUri) {
        this.dataUri = dataUri;
    }

    public User getAuthor() {
        return author;
    }

    public String getDataUri() {
        return dataUri;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getVideoImageUri() {
        return videoImageUri;
    }

    public String getVideoLength() {
        return videoLength;
    }

    public int getPlayCount() {
        return playCount;
    }

    public User getWriter() {
        return author;
    }

    public List<Tip> getTips() {
        return tips;
    }

    public List<Video> getResembleVideos() {
        return resembleVideos;
    }
}
