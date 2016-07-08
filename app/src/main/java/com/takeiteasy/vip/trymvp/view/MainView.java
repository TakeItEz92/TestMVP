package com.takeiteasy.vip.trymvp.view;

import com.takeiteasy.vip.trymvp.model.FirebaseDataItem;

import java.util.List;

/**
 * Created by VLogachev on 08.07.2016.
 */
public interface MainView {
    void showProgress();
    void hideProgress();
    void setItems(List<FirebaseDataItem> data);
    void showError(String error);
}
