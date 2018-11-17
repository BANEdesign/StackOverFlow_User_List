package com.bryonnabaines.stackoverflow_user_list.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class User {

    @PrimaryKey
    @NonNull
    @SerializedName("user_id")
    @Expose
    private int user_id;

    @SerializedName("bronze")
    @Expose
    private int bronze;

    @SerializedName("silver")
    @Expose
    private int silver;

    @SerializedName("gold")
    @Expose
    private int gold;

    @SerializedName("profile_image")
    @Expose
    private String profile_image;

    @SerializedName("display_name")
    @Expose
    private String display_name;

    @SerializedName("location")
    @Expose
    private String location;

    public User(int user_id, int bronze, int silver, int gold, String profile_image, String display_name, String location) {
        this.bronze = bronze;
        this.silver = silver;
        this.gold = gold;
        this.user_id = user_id;
        this.display_name = display_name;
        this.location = location;
        this.profile_image = profile_image;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

//    public Integer getBadge_counts(String type) {
//        switch (type){
//            case "bronze" : return badge_counts.get(0);
//            case "silver" : return badge_counts.get(1);
//            case "gold" : return badge_counts.get(2);
//            default : return 0;
//        }
//    }
//
//    public void setBadge_counts(BadgeCount badge_counts) {
//        ArrayList<Integer> badgeList = new ArrayList<>(3);
//        badgeList.add(0,badge_counts.getBronze());
//        badgeList.add(1, badge_counts.getSilver());
//        badgeList.add(2, badge_counts.getGold());
//        this.badge_counts = badgeList;
//    }



}

