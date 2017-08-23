package com.wnd.pawoon.di;

import com.wnd.pawoon.network.api.PawoonNetworkService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Wandy on 6/5/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkingModule.class})
public interface ApplicationComponent {
    PawoonNetworkService pawoonNetworkService();
}
