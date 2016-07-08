package com.takeiteasy.vip.trymvp.model;

/**
 * Created by VLogachev on 08.07.2016.
 */
public abstract class FirebaseNode {
    private String uid;

    public FirebaseNode() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "FirebaseNode{" +
                "uid='" + uid + '\'' +
                '}';
    }
}
