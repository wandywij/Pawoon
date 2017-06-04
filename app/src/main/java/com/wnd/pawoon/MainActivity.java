package com.wnd.pawoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.wnd.pawoon.di.DaggerToDoListComponent;
import com.wnd.pawoon.di.ToDoListComponent;
import com.wnd.pawoon.di.ToDoListModule;
import com.wnd.pawoon.domain.ToDoListInteractor;
import com.wnd.pawoon.model.ToDoModel;
import com.wnd.pawoon.network.BaseNetworkManager;
import com.wnd.pawoon.network.api.ApiService;
import com.wnd.pawoon.presenter.ToDoListPresenter;
import com.wnd.pawoon.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    ToDoListPresenter presenter;

    private ToDoListComponent component;

    @BindView(R.id.toDoListButton)
    public Button toDoListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        component = DaggerToDoListComponent.builder()
                .applicationComponent(((PawoonApplication) getApplication()).getAppComponent())
                .toDoListModule(new ToDoListModule(this))
                .build();
        component.inject(this);
        presenter.onAttachView(this);
        presenter.getToDos();

        ButterKnife.bind(this);
    }

    @Override
    public void onFetched(List<ToDoModel> toDoModels) {
    }

    @OnClick(R.id.toDoListButton)
    public void navigate() {
        Intent i = new Intent(this, ToDoListActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetachview(this);
    }
}
