package com.wnd.pawoon.presenter;

import android.util.Log;

import com.wnd.pawoon.domain.ToDoListInteractor;
import com.wnd.pawoon.model.ToDoModel;
import com.wnd.pawoon.network.BaseNetworkManager;
import com.wnd.pawoon.network.api.ApiService;
import com.wnd.pawoon.view.MainView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Wandy on 5/25/17.
 */

public class ToDoListPresenter implements BasePresenter<MainView> {

    private MainView mainView;
    private Disposable subscription;
    private ToDoListInteractor interactor;

    public ToDoListPresenter(ToDoListInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onAttachView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onDetachview(MainView mainView) {
        subscription.dispose();
        this.mainView = null;
    }

    public void getToDos() {
        subscription = interactor.getToDoList().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<ToDoModel>>() {
                    @Override
                    public void accept(@NonNull List<ToDoModel> toDoModels) throws Exception {
                        for (ToDoModel model: toDoModels) {
                            Log.d("result", "todo " + model.title);
                        }
                    }
                });
    }
}
