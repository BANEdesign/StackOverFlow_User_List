package com.bryonnabaines.stackoverflow_user_list.models;

public class BadgeCount {
    public int bronze;
    public int silver;
    public int gold;

    public BadgeCount( int bronze, int silver, int gold){
        this.bronze = bronze;
        this.silver = silver;
        this.gold = gold;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
