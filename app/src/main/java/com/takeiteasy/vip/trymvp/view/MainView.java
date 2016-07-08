package com.takeiteasy.vip.trymvp.view;

import com.takeiteasy.vip.trymvp.ui.models.DataAdapterItem;

import java.util.List;

/**
 * Created by VLogachev on 08.07.2016.
 */
public interface MainView {
    void showProgress();
    void hideProgress();
    void showItems(List<DataAdapterItem> data);
    void showError(String error);
}
