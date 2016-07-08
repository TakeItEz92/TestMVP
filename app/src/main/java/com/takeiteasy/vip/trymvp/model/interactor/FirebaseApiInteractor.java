package com.takeiteasy.vip.trymvp.model.interactor;

import com.takeiteasy.vip.trymvp.model.FirebaseNode;

import java.util.List;

/**
 * Created by VLogachev on 08.07.2016.
 */
public interface FirebaseApiInteractor<T extends FirebaseNode> {

    interface FirebaseCallback<E> {
        void onLoadFinished(List<E> data);
        void onLoadFailed(String error);
    }

    void loadDataItems(FirebaseCallback<T> callback);
}
