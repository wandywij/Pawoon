package com.wnd.pawoon.presenter;

import android.util.Log;

import com.wnd.pawoon.model.ToDoModel;
import com.wnd.pawoon.network.BaseNetworkManager;
import com.wnd.pawoon.network.api.ToDoListAPI;
import com.wnd.pawoon.view.MainView;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;


/**
 * Created by Wandy on 5/25/17.
 */

public class MainActivityPresenter implements BasePresenter<MainView> {

    private static ToDoListAPI toDoListAPI;
    private MainView mainView;

    public MainActivityPresenter() {
    }

    private static ToDoListAPI getToDoListApi() {
        if (toDoListAPI == null)
            toDoListAPI = new BaseNetworkManager().getRetrofit().create(ToDoListAPI.class);
        return toDoListAPI;
    }

    @Override
    public void onAttachView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onDetachview(MainView mainView) {
        this.mainView = null;
    }

    public void getToDos() {
        getToDoListApi()
                .getToDos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableSubscriber<List<ToDoModel>>() {
                    @Override
                    public void onNext(List<ToDoModel> toDoModels) {
                        mainView.onFetched(toDoModels);
                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }



}
