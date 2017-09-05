package com.wnd.pawoon.network.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.wnd.pawoon.model.ToDoModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Wandy on 6/5/17.
 */

public class PawoonNetworkServiceImpl implements PawoonNetworkService {

    public ApiService apiService;

    @Inject
    Context context;

    SharedPreferences sharedPreferences;

    public PawoonNetworkServiceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<ToDoModel>> getToDoList() {
        //sharedPreferences = context.getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
        //sharedPreferences.edit().putString("yellow", "another lorem ipsum").commit();
        //Log.d(PawoonNetworkServiceImpl.class.getSimpleName()
                //, sharedPreferences.getString("yellow", "kosong"));

        return apiService.getToDos();
    }
}
