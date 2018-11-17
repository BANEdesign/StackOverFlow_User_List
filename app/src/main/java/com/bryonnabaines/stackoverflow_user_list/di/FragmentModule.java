package com.bryonnabaines.stackoverflow_user_list.di;

import com.bryonnabaines.stackoverflow_user_list.fragments.UserListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract UserListFragment contributeUserListFragment();
}
