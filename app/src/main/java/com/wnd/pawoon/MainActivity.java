package com.wnd.pawoon;

import android.util.Log;
import android.widget.Button;

import com.wnd.pawoon.di.DaggerToDoListComponent;
import com.wnd.pawoon.di.ToDoListComponent;
import com.wnd.pawoon.di.ToDoListModule;
import com.wnd.pawoon.model.ToDoModel;
import com.wnd.pawoon.presenter.ToDoListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {

    @Inject
    ToDoListPresenter presenter;

    private ToDoListComponent toDoListComponent;
    Disposable disposable;

    @BindView(R.id.toDoListButton)
    public Button toDoListButton;

    @Override
    void onCreate() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        toDoListComponent = DaggerToDoListComponent.builder()
                .applicationComponent(((PawoonApplication) getApplication()).getAppComponent())
                .toDoListModule(new ToDoListModule(this))
                .build();
        toDoListComponent.inject(this);
        disposable = presenter.onResume(new Consumer<List<ToDoModel>>() {
            @Override
            public void accept(@NonNull List<ToDoModel> toDoModels) throws Exception {
                for(ToDoModel model : toDoModels) {
                }
            }
        });
        ButterKnife.bind(this);
    }


    public void onFetched(List<ToDoModel> toDoModels) {

    }

    @OnClick(R.id.toDoListButton)
    public void navigateToToDoListActivity() {
        navigateTo(ToDoListActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
