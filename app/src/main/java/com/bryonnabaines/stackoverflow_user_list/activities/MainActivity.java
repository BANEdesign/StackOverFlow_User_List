package com.bryonnabaines.stackoverflow_user_list.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bryonnabaines.stackoverflow_user_list.R;

import com.bryonnabaines.stackoverflow_user_list.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, UserListFragment.newInstance())
                    .commitNow();
        }
    }
}
