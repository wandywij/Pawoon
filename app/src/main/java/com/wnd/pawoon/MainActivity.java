package com.wnd.pawoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wnd.pawoon.model.ToDoModel;
import com.wnd.pawoon.presenter.MainActivityPresenter;
import com.wnd.pawoon.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainActivityPresenter presenter;
    @BindView(R.id.toDoListButton)
    public Button toDoListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter = new MainActivityPresenter();
        presenter.onAttachView(this);
        presenter.getToDos();
    }

    @Override
    public void onFetched(List<ToDoModel> toDoModels) {
    }

    @OnClick(R.id.toDoListButton)
    public void navigate() {
        Intent i = new Intent(this, ToDoListActivity.class);
        startActivity(i);
    }
}
