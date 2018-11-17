package com.bryonnabaines.stackoverflow_user_list.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.bryonnabaines.stackoverflow_user_list.models.User;

@Database(entities = {User.class}, version = 1)
@TypeConverters(BadgeConverter.class)
public abstract class UserDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile UserDatabase INSTANCE;

    // --- DAO ---
    public abstract UserDao userDao();
}

