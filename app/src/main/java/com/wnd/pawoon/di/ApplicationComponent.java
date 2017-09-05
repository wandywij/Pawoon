package com.wnd.pawoon.di;

import android.content.SharedPreferences;

import com.wnd.pawoon.MainActivity;
import com.wnd.pawoon.network.api.PawoonNetworkService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Wandy on 6/5/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkingModule.class, SharedPreferenceModule.class})
public interface ApplicationComponent {
    PawoonNetworkService pawoonNetworkService();
    SharedPreferences sharedPreferences();
    //void inject();
}
