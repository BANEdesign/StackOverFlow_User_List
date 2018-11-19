package com.bryonnabaines.stackoverflow_user_list.database;

import android.arch.persistence.room.TypeConverter;

import com.bryonnabaines.stackoverflow_user_list.models.BadgeCount;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BadgeConverter {

    //TODO This might not be needed, delete if you can make it work w/o
    static Gson gson = new Gson();

    @TypeConverter
    public static List<BadgeCount> stringToBadgeCountList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<BadgeCount>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String badgeCountListToString(List<BadgeCount> badgeCounts) {
        return gson.toJson(badgeCounts);
    }
}