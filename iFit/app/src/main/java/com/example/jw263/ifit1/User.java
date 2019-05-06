package com.example.jw263.ifit1;

public class User {
    private int mID;
    private String mUserName;
    private int mAge;

    //Constructor with all data
    public User(int id, String name, int age){
        mID = id;
        mUserName = name;
        mAge = age;
    }

    //Constructor with no ID
    public User(String name, int age){
        mUserName = name;
        mAge = age;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }
}
