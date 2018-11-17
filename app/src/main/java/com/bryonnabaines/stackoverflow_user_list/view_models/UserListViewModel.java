package com.bryonnabaines.stackoverflow_user_list.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.bryonnabaines.stackoverflow_user_list.database.UsersRepository;
import com.bryonnabaines.stackoverflow_user_list.models.User;

import java.util.List;

import javax.inject.Inject;

public class UserListViewModel extends ViewModel {

    private LiveData<List<User>> users;
    private UsersRepository userRepo;

    @Inject
    public UserListViewModel(UsersRepository usersRepo) {
        this.userRepo = usersRepo;
    }

    public void init() {
        if (this.users != null) {
            return;
        }
        users = userRepo.getUsers();
    }

    public LiveData<List<User>> getUsers() {
        return this.users;
    }
}
