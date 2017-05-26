package com.wnd.pawoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wnd.pawoon.model.ToDoModel;
import com.wnd.pawoon.presenter.MainActivityPresenter;
import com.wnd.pawoon.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
