package com.bryonnabaines.stackoverflow_user_list.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bryonnabaines.stackoverflow_user_list.R;
import com.bryonnabaines.stackoverflow_user_list.models.User;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {



    private ArrayList<User> users;
    private static String BRONZE = "bronze";
    private static String SILVER = "silver";
    private static String GOLD = "gold";

    public UserListAdapter(ArrayList<User> users) {
        this.users = users;
    }

    public UserListAdapter(){}

    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card_view_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {

        Glide.with(holder.itemView)
                .load(users.get(position).getProfile_image())
                .into(holder.gravatar);
        holder.username.setText(users.get(position).getDisplay_name());
        holder.bronzeAmount.setText(users.get(position).getBadge_counts(BRONZE));
        holder.silverAmount.setText(users.get(position).getBadge_counts(SILVER));
        holder.goldAmount.setText(users.get(position).getBadge_counts(GOLD));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users) {
        this.users.addAll(users);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //TODO add viewHolders for other fields in User Object
        private ImageView gravatar;
        private TextView username;
        private TextView bronzeAmount;
        private TextView silverAmount;
        private TextView goldAmount;

        public ViewHolder(View itemView) {
            super(itemView);

            gravatar = itemView.findViewById(R.id.gravatar);
            username = itemView.findViewById(R.id.username);
            bronzeAmount = itemView.findViewById(R.id.bronze_amount);
            silverAmount = itemView.findViewById(R.id.silver_amount);
            goldAmount = itemView.findViewById(R.id.gold_amount);

        }
    }
}