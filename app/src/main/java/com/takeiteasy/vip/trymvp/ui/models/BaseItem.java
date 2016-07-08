package com.takeiteasy.vip.trymvp.ui.models;

import com.takeiteasy.vip.trymvp.model.FirebaseNode;

/**
 * Created by VLogachev on 08.07.2016.
 */
public abstract class BaseItem<T extends FirebaseNode> {

    protected abstract void parse(T node);
}
