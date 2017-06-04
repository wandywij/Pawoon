package com.wnd.pawoon.domain;

import com.wnd.pawoon.model.ToDoModel;
import com.wnd.pawoon.network.api.ApiService;
import com.wnd.pawoon.network.api.PawoonNetworkService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Wandy on 6/3/17.
 */

public class ToDoListInteractor {

    PawoonNetworkService networkService;

    public ToDoListInteractor(PawoonNetworkService networkService) {
        this.networkService = networkService;
    }

    public Observable<List<ToDoModel>> getToDoList() {
        return networkService.getToDoList();
    }
}
