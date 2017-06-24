package com.wnd.pawoon.network.api;

import com.wnd.pawoon.model.ToDoModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Wandy on 6/5/17.
 */

public class PawoonNetworkServiceImpl implements PawoonNetworkService {

    public ApiService apiService;

    public PawoonNetworkServiceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<ToDoModel>> getToDoList() {
        return apiService.getToDos();
    }
}
