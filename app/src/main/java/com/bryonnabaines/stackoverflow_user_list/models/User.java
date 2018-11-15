package com.bryonnabaines.stackoverflow_user_list.models;

public class User {

    private BadgeCount badge_counts;
    private int user_id;
    private String profile_image;
    private String display_name;
    private String location;

    private boolean followed = false;
    private boolean blocked = false;

    public User(BadgeCount badge_counts, int id, String name, String location) {
        this.badge_counts = badge_counts;
        this.user_id = id;
        this.display_name = name;
        this.location = location;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Integer getBadge_counts(String type) {
        switch (type){
            case "bronze" : return badge_counts.getBronze();
            case "silver" : return badge_counts.getSilver();
            case "gold" : return badge_counts.getGold();
            default : return 0;
        }
    }

    public void setBadge_counts(BadgeCount badge_counts) {
        this.badge_counts = badge_counts;
    }

    private class BadgeCount {
        public Integer bronze;
        public Integer silver;
        public Integer gold;

        public BadgeCount( Integer bronze, Integer silver, Integer gold){
            this.bronze = bronze;
            this.silver = silver;
            this.gold = gold;
        }

        public Integer getBronze() {
            return bronze;
        }

        public void setBronze(Integer bronze) {
            this.bronze = bronze;
        }

        public Integer getSilver() {
            return silver;
        }

        public void setSilver(Integer silver) {
            this.silver = silver;
        }

        public Integer getGold() {
            return gold;
        }

        public void setGold(Integer gold) {
            this.gold = gold;
        }
    }
}

