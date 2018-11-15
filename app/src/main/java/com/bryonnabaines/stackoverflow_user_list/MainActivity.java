package com.bryonnabaines.stackoverflow_user_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bryonnabaines.stackoverflow_user_list.ui.userlist.UserListFragment;

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
