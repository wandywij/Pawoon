package com.wnd.pawoon.presenter;

import android.util.Log;

import com.wnd.pawoon.domain.ToDoListInteractor;
import com.wnd.pawoon.model.ToDoModel;
import com.wnd.pawoon.network.BaseNetworkManager;
import com.wnd.pawoon.network.api.ApiService;
import com.wnd.pawoon.view.MainView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;


/**
 * Created by Wandy on 5/25/17.
 */

public class ToDoListPresenter {

    private ToDoListInteractor interactor;
    private BehaviorSubject<List<ToDoModel>> behaviorSubject = BehaviorSubject.create();;

    public ToDoListPresenter(ToDoListInteractor interactor) {
        this.interactor = interactor;
    }

    private void getToDos() {
        interactor.getToDoList()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<ToDoModel>>() {
                    @Override
                    public void accept(@NonNull List<ToDoModel> toDoModels) throws Exception {
                        behaviorSubject.onNext(toDoModels);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });
    }

    public Disposable onResume(Consumer<List<ToDoModel>> getToDosAction) {
        getToDos();
        return behaviorSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getToDosAction);
    }
}
