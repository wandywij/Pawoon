package com.wnd.pawoon;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.wnd.pawoon.di.ApplicationComponent;
import com.wnd.pawoon.di.ApplicationModule;
import com.wnd.pawoon.di.DaggerApplicationComponent;
import com.wnd.pawoon.di.NetworkingModule;
import com.wnd.pawoon.di.SharedPreferenceModule;

/**
 * Created by Wandy on 6/5/17.
 */

public class PawoonApplication extends MultiDexApplication {

    ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkingModule(new NetworkingModule(this))
                .sharedPreferenceModule(new SharedPreferenceModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}