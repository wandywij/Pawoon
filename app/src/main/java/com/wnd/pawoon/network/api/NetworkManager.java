package com.wnd.pawoon.network.api;

import com.wnd.pawoon.network.BaseNetworkManager;

import retrofit2.Retrofit;

/**
 * Created by Wandy on 5/26/17.
 */

public class NetworkManager<T> extends BaseNetworkManager {
    private T api;
    private Class<T> apiClass;

    public T getInstance() {
        if (api == null) {
            api = create(apiClass);
        }
        return api;
    }

    public NetworkManager(Class<T> t) {
        apiClass = t;
    }

    private <T> T create(Class<T> service) {
        return (T) getRetrofit()
                .create(service);
    }
}
