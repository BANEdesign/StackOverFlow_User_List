package com.bryonnabaines.stackoverflow_user_list.models;

import java.util.ArrayList;

/**
 * This Object is a wrapper to help retrofit retrieve the user list
 */
public class UserList {
    ArrayList<User> items;

    public UserList( ArrayList<User> items){
        this.items = items;
    }

    public ArrayList<User> getItems() {
        return items;
    }

    public void setItems(ArrayList<User> items) {
        this.items = items;
    }
}
