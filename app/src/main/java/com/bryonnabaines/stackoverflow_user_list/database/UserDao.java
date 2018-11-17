package com.bryonnabaines.stackoverflow_user_list.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.bryonnabaines.stackoverflow_user_list.models.User;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {


    @Insert(onConflict = REPLACE)
    void insertAll(List<User> users);

    @Query("SELECT * FROM user")
    LiveData<List<User>> load();

    @Query("SELECT * FROM user LIMIT 1")
    User hasUsers();

}
