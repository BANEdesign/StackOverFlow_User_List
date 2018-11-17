package com.bryonnabaines.stackoverflow_user_list.database;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.bryonnabaines.stackoverflow_user_list.App;
import com.bryonnabaines.stackoverflow_user_list.api.UserService;
import com.bryonnabaines.stackoverflow_user_list.models.User;
import com.bryonnabaines.stackoverflow_user_list.models.UserList;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class UsersRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 1;

    private UserService userService;
    private final UserDao userDao;
    private final Executor executor;


    @Inject
    public UsersRepository(UserService userService, UserDao userDao, Executor executor) {
        this.userService = userService;
        this.userDao = userDao;
        this.executor = executor;
    }

    // ---

    public LiveData<List<User>> getUsers() {
//        boolean usersExist = (userDao.hasUsers() != null);
//        if(!usersExist) {
//            userService.getUsers()
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(users -> userDao.save(users));
//        }
        refreshUser();
        return userDao.load(); // return a LiveData directly from the database.
    }

    private void refreshUser() {
//        executor.execute(() -> {
            // Check if user was fetched recently
//            boolean usersExists = (userDao.hasUsers() != null);
            // If user have to be updated
//            if (usersExists) {
                userService.getUsers().enqueue(new Callback<UserList>() {
                    @Override
                    public void onResponse(@NonNull Call<UserList> call, @NonNull Response<UserList> response) {
                        Log.d("TAG", "DATA REFRESHED FROM NETWORK");
                        Toast.makeText(App.context, "Data refreshed from network !", Toast.LENGTH_LONG).show();
//                        executor.execute(() -> {
                            if (response.isSuccessful()) {
                                assert response.body() != null;
                                Observable.just(response.body())
                                        .subscribeOn(Schedulers.io())
                                        .subscribe( users -> userDao.insertAll(users.getItems()));
//                                userDao.insertAll(response.body().getItems());
                            }
//                        });
                    }

                    @Override
                    public void onFailure(Call<UserList> call, Throwable t) {
                        Log.e("TAG", "ERROR FETCHING DATA");
                    }
                });
//            }
//        });
    }
}

