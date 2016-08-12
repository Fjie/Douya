package me.fanjie.douya.model;

/**
 * Created by fanji on 2015/8/16.
 */
public class Tip implements ModelInterface {

    private User writer;

    private String tipContent;
    private String issueTime;
    private int likeCount;

    public Tip(User writer, String tipContent, String issueTime, int likeCount) {
        this.writer = writer;
        this.tipContent = tipContent;
        this.issueTime = issueTime;
        this.likeCount = likeCount;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public void setTipContent(String tipContent) {
        this.tipContent = tipContent;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public User getWriter() {
        return writer;
    }

    public String getTipContent() {
        return tipContent;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public int getLikeCount() {
        return likeCount;
    }
}
