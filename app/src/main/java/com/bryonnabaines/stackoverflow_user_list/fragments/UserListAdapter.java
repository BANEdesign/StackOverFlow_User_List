package com.bryonnabaines.stackoverflow_user_list.fragments;

import android.support.v7.widget.CardView;
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



    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(ArrayList<User> users) {
        this.users = users;
    }

    public UserListAdapter(){ }

    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card_view_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {

        User user = this.users.get(position);
        Glide.with(holder.itemView)
                .load(user.profile_image)
                .into(holder.gravatar);
        holder.username.setText(String.valueOf(user.display_name));
        holder.bronzeAmount.setText(String.valueOf(user.badge_counts.bronze));
        holder.silverAmount.setText(String.valueOf(user.badge_counts.silver));
        holder.goldAmount.setText(String.valueOf(user.badge_counts.gold));
    }

    @Override
    public int getItemCount() {
        if(users != null) {
            return users.size();
        }else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //TODO add viewHolders for location field
        private CardView cardView;
        private ImageView gravatar;
        private TextView username;
        private TextView bronzeAmount;
        private TextView silverAmount;
        private TextView goldAmount;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            gravatar = itemView.findViewById(R.id.gravatar);
            username = itemView.findViewById(R.id.username);
            bronzeAmount = itemView.findViewById(R.id.bronze_amount);
            silverAmount = itemView.findViewById(R.id.silver_amount);
            goldAmount = itemView.findViewById(R.id.gold_amount);
        }
    }
}