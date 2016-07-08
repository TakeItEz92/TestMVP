package com.takeiteasy.vip.trymvp.ui.models;

import com.takeiteasy.vip.trymvp.model.FirebaseDataItem;

/**
 * Created by VLogachev on 08.07.2016.
 */
public class DataAdapterItem extends BaseItem<FirebaseDataItem> {
    private String uid;
    private String name;
    private String sex;

    public DataAdapterItem(FirebaseDataItem node) {
        parse(node);
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    @Override
    protected void parse(FirebaseDataItem node) {
        uid = node.getUid();
        name = node.getUser_name();
        sex = node.getSex();
    }
}
