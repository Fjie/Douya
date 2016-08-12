package me.fanjie.douya.model;

/**
 * Created by fanji on 2015/8/16.
 */
public class User implements ModelInterface{

    private String userName;
    private String userResume;
    private String userImageUri;

    private String sex;
    private String city;

    public User(String userName, String userResume) {
        this.userName = userName;
        this.userResume = userResume;
    }

    public User(String userName, String userResume, String userImageUri) {
        this.userName = userName;
        this.userResume = userResume;
        this.userImageUri = userImageUri;
    }

    public User(String userName, String userResume, String userImageUri, String sex, String city) {
        this.userName = userName;
        this.userResume = userResume;
        this.userImageUri = userImageUri;
        this.sex = sex;
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserImageUri(String userImageUri) {
        this.userImageUri = userImageUri;
    }

    public void setUserResume(String userResume) {
        this.userResume = userResume;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserImageUri() {
        return userImageUri;
    }

    public String getUserResume() {
        return userResume;
    }
}
