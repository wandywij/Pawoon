package com.wnd.pawoon;

import android.app.Application;

import com.wnd.pawoon.di.ApplicationComponent;
import com.wnd.pawoon.di.ApplicationModule;
import com.wnd.pawoon.di.DaggerApplicationComponent;
import com.wnd.pawoon.di.NetworkingModule;

/**
 * Created by Wandy on 6/5/17.
 */

public class PawoonApplication extends Application {

    ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkingModule(new NetworkingModule())
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }
}