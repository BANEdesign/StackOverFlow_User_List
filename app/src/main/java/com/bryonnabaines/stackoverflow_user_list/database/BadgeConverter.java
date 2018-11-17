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
    public static ArrayList<Integer> badgeCounToArrayList(BadgeCount badges) {
        ArrayList<Integer> badgeList = new ArrayList<>(3);
        badgeList.add(0, badges.getBronze());
        badgeList.add( 1, badges.getSilver());
        badgeList.add(2, badges.getGold());

        return badgeList;
    }
}