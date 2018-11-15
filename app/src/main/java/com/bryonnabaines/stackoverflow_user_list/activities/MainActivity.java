package com.bryonnabaines.stackoverflow_user_list.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bryonnabaines.stackoverflow_user_list.R;

import com.bryonnabaines.stackoverflow_user_list.fragments.UserListFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureDagger();
        this.showFragment(savedInstanceState);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    private void showFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            // TODO remove this stuff if we don't need to send anything to fragment/viewModel
//            UserListFragment fragment = new UserListFragment();
//            Bundle bundle = new Bundle();

//            bundle.putString(SOMETHING_TO_PASS);
//            fragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, UserListFragment.newInstance())
                    .commitNow();
        }
    }

    private void configureDagger(){
        AndroidInjection.inject(this);
    }
}
