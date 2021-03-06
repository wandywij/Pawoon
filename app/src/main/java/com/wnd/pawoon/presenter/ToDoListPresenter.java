package com.wnd.pawoon.presenter;

import com.wnd.pawoon.domain.ToDoListInteractor;
import com.wnd.pawoon.model.ToDoModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;


/**
 * Created by Wandy on 5/25/17.
 */

public class ToDoListPresenter {

    private ToDoListInteractor interactor;
    private BehaviorSubject<List<ToDoModel>> behaviorSubject = BehaviorSubject.create();

    public ToDoListPresenter(ToDoListInteractor interactor) {
        this.interactor = interactor;
    }

    public void getToDos() {
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

    public int addNumber(int a, int b) {
        return a+b;
    }

    public Disposable onResume(Consumer<List<ToDoModel>> getToDosAction) {
        getToDos();
        return behaviorSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getToDosAction);
    }
}
