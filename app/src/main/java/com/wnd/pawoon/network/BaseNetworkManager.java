package com.wnd.pawoon.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wnd.pawoon.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wandy on 5/25/17.
 */

public class BaseNetworkManager {

    private static Retrofit retrofit;
    //private static Retrofit retrofitToken;

    public Retrofit getRetrofit() {
        if (null == retrofit) {
            retrofit = initiateRetrofit(getHttpClient());
        }
        return retrofit;
    }

    protected static Retrofit initiateRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}

