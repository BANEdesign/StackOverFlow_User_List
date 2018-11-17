package com.bryonnabaines.stackoverflow_user_list.database;

import android.arch.persistence.room.TypeConverter;

import com.bryonnabaines.stackoverflow_user_list.models.BadgeCount;

import java.util.ArrayList;

public class BadgeConverter {
    @TypeConverter
    public static BadgeCount fromArrayList(ArrayList<Integer> arr){
        BadgeCount badgeCount = new BadgeCount(arr.get(0), arr.get(1), arr.get(2));

        return badgeCount;
    }

    @TypeConverter
    public static ArrayList<String> badgeCounToArrayList(BadgeCount badges) {
        return new ArrayList<>(3);
    }
}