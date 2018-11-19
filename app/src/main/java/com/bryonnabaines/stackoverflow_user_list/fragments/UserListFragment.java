package com.bryonnabaines.stackoverflow_user_list.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bryonnabaines.stackoverflow_user_list.R;
import com.bryonnabaines.stackoverflow_user_list.view_models.UserListViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class UserListFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private UserListViewModel viewModel;

    RecyclerView recyclerView;
    UserListAdapter userListAdapter;

    public static UserListFragment newInstance() {
        return new UserListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.userlist);
        setupAdapter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userListAdapter = new UserListAdapter();
        this.configureDagger();
        this.configureViewModel();

    }

    private void setupAdapter(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(userListAdapter);
    }

    private void configureViewModel(){
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserListViewModel.class);
        viewModel.init();
        viewModel.getUsers().observe(this, users ->
                recyclerView.setAdapter(new UserListAdapter(new ArrayList<>(users))));
    }

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }
}
