package com.wnd.pawoon.di;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wandy on 9/5/17.
 */

@Module
public class SharedPreferenceModule {
    public static final String PREFS_NAME = "MyPrefsFile";
    private Context context;

    public SharedPreferenceModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences(PREFS_NAME, 0);
    }

//    @Provides
//    @Singleton
//    public Context provideContext() {
//        return this.context;
//    }


}
