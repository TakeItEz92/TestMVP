package com.takeiteasy.vip.trymvp.presenter;

import com.takeiteasy.vip.trymvp.model.FirebaseDataItem;
import com.takeiteasy.vip.trymvp.model.interactor.FirebaseApiInteractor;
import com.takeiteasy.vip.trymvp.model.interactor.MainInteractorImpl;
import com.takeiteasy.vip.trymvp.view.MainView;

import java.util.List;

/**
 * Created by VLogachev on 08.07.2016.
 */
public class MainPresenterImpl implements MainPresenter, FirebaseApiInteractor.FirebaseCallback<FirebaseDataItem> {

    private MainView view;
    private FirebaseApiInteractor<FirebaseDataItem> interactor;

    public MainPresenterImpl() {
        interactor = new MainInteractorImpl();
    }

    @Override
    public void subscribe(MainView view) {
        if (this.view == null) {
            this.view = view;
        }
    }

    @Override
    public void unsubscribe() {
        view = null;
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.showProgress();
        }

        interactor.loadDataItems(this);
    }

    @Override
    public void onLoadFinished(List<FirebaseDataItem> data) {
        if (view != null) {
            view.hideProgress();
            view.setItems(data);
        }
    }

    @Override
    public void onLoadFailed(String error) {
        if (view != null) {
            view.hideProgress();
            view.showError(error);
        }
    }
}
