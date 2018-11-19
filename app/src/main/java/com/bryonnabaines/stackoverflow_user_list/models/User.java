package com.bryonnabaines.stackoverflow_user_list.models;

import android.arch.persistence.room.Embedded;
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
    public int user_id;


    @Embedded(prefix = "badge_counts")
    public BadgeCount badge_counts;

    @SerializedName("profile_image")
    @Expose
    public String profile_image;

    @SerializedName("display_name")
    @Expose
    public String display_name;

    @SerializedName("location")
    @Expose
    public String location;



    public User(int user_id, BadgeCount badge_counts, String profile_image, String display_name, String location) {
        this.badge_counts = badge_counts;
        this.user_id = user_id;
        this.display_name = display_name;
        this.location = location;
        this.profile_image = profile_image;
    }
}

