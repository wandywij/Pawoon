package com.wnd.pawoon.di;

import com.wnd.pawoon.MainActivity;

import dagger.Component;

/**
 * Created by Wandy on 6/4/17.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = { ToDoListModule.class })
public interface ToDoListComponent {
    void inject(MainActivity mainActivity);
}
