package com.bryonnabaines.stackoverflow_user_list.di;

import com.bryonnabaines.stackoverflow_user_list.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();
}
