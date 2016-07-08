package com.takeiteasy.vip.trymvp.model;

/**
 * Created by VLogachev on 08.07.2016.
 */
public class FirebaseDataItem extends FirebaseNode {
    private String user_name;
    private String sex;

    public FirebaseDataItem() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "FirebaseDataItem{" +
                "user_name='" + user_name + '\'' +
                ", sex='" + sex + '\'' +
                "} " + super.toString();
    }
}
