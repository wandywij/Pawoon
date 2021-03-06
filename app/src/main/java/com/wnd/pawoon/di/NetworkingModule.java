package com.wnd.pawoon.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wnd.pawoon.Constant;
import com.wnd.pawoon.network.BaseNetworkManager;
import com.wnd.pawoon.network.api.ApiService;
import com.wnd.pawoon.network.api.PawoonNetworkService;
import com.wnd.pawoon.network.api.PawoonNetworkServiceImpl;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wandy on 6/4/17.
 */

@Module
public class NetworkingModule {

    SharedPreferences sharedPreferences;


    private final String PREFS_NAME = "MyPrefsFile";

    private Context context;
    public NetworkingModule(Context context) {
        this.context = context;
    }

    @Provides @Singleton
    public PawoonNetworkService getNetworkService(ApiService apiService) {
        return new PawoonNetworkServiceImpl(apiService);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {

        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        sharedPreferences.edit().putString("hellow", "lorem ipsum dolor").commit();

        Log.d(NetworkingModule.class.getSimpleName(), sharedPreferences.getString("hi", "empty string"));

        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
    }



    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }



}
