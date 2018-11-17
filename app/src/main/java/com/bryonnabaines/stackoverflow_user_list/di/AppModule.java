package com.bryonnabaines.stackoverflow_user_list.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.bryonnabaines.stackoverflow_user_list.api.UserService;
import com.bryonnabaines.stackoverflow_user_list.database.UserDao;
import com.bryonnabaines.stackoverflow_user_list.database.UserDatabase;
import com.bryonnabaines.stackoverflow_user_list.database.UsersRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {

    // --- DATABASE INJECTION ---

    @Provides
    @Singleton
    UserDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                UserDatabase.class, "MyDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(UserDatabase database) { return database.userDao(); }

    // --- REPOSITORY INJECTION ---

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    UsersRepository provideUserRepository(UserService userService, UserDao userDao, Executor executor) {
        return new UsersRepository(userService, userDao, executor);
    }

    // --- NETWORK INJECTION ---

    private static String BASE_URL = "https://api.github.com/";

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    UserService provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(UserService.class);
    }
}
