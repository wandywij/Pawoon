package com.wnd.pawoon.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.wnd.pawoon.PawoonApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public final class ApplicationModule {
    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }


    @Provides
    @Named("application")
    @Singleton
    Context provideApplicationContext() {
        return context;
    }

    /*@Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences("hehe", 0);
    }*/
}
