package com.bryonnabaines.stackoverflow_user_list.models;

public class BadgeCount {
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
