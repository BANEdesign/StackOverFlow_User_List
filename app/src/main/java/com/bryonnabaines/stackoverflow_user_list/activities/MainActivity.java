package com.bryonnabaines.stackoverflow_user_list.activities;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

import com.bryonnabaines.stackoverflow_user_list.R;

import com.bryonnabaines.stackoverflow_user_list.fragments.UserListFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {


    ProgressBar progressSpinner;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressSpinner = this.findViewById(R.id.progressBar);
        progressSpinner.setVisibility(View.VISIBLE);
        progressSpinner.setIndeterminate(true);
        this.configureDagger();
        this.showFragment(savedInstanceState);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    private void showFragment(Bundle savedInstanceState){

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, UserListFragment.newInstance())
                    .commitNow();
        }
        progressSpinner.setIndeterminate(false);
    }

    private void configureDagger(){
        AndroidInjection.inject(this);
    }
}
