package com.bryonnabaines.stackoverflow_user_list.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.bryonnabaines.stackoverflow_user_list.models.User;

import java.util.List;

import javax.inject.Inject;

public class UserListViewModel extends ViewModel {

    private LiveData<List<User>> users;
    private UserRepository userRepo;

    @Inject
    public UserProfileViewModel(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void init() {
        if (this.user != null) {
            return;
        }
        user = userRepo.getUsers();
    }

    public LiveData<List<User>> getUsers() {
        return this.user;
    }
}
