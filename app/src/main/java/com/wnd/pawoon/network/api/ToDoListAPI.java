package com.wnd.pawoon.network.api;

import com.wnd.pawoon.model.ToDoModel;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Wandy on 5/25/17.
 */

public interface ToDoListAPI {
    @GET("todos")
    Flowable<List<ToDoModel>> getToDos();
}
