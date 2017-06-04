package com.wnd.pawoon.network.api;

import com.wnd.pawoon.model.ToDoModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Wandy on 6/5/17.
 */

public interface PawoonNetworkService {

    Observable<List<ToDoModel>> getToDoList();
}
