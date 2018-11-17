package com.bryonnabaines.stackoverflow_user_list.api;

import com.bryonnabaines.stackoverflow_user_list.models.User;
import com.bryonnabaines.stackoverflow_user_list.models.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("https://api.stackexchange.com/2.2/users?site=stackoverflow")
    Call<UserList> getUsers();
}
