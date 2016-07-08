package com.takeiteasy.vip.trymvp.presenter;

import com.takeiteasy.vip.trymvp.view.MainView;

/**
 * Created by VLogachev on 08.07.2016.
 */
public interface MainPresenter {
    void subscribe(MainView view);
    void unsubscribe();
    void loadData();
}
