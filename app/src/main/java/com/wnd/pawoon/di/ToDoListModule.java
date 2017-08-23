package com.wnd.pawoon.di;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.wnd.pawoon.domain.ToDoListInteractor;
import com.wnd.pawoon.network.api.PawoonNetworkService;
import com.wnd.pawoon.presenter.ToDoListPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wandy on 6/4/17.
 */

@Module
public class ToDoListModule {

    private final AppCompatActivity activity;

    public ToDoListModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides @Named("activity")
    @ActivityScope
    Context provideActivityContext() {
        return activity;
    }

    @Provides
    @ActivityScope
    public ToDoListInteractor provideToDoListInteractor(PawoonNetworkService networkService) {
        return new ToDoListInteractor(networkService);
    }

    @Provides
    @ActivityScope
    public ToDoListPresenter provideToDoListPresenter(ToDoListInteractor interactor) {
        return new ToDoListPresenter(interactor);
    }
}
