package com.wnd.pawoon.view;

import com.wnd.pawoon.model.ToDoModel;

import java.util.List;

/**
 * Created by Wandy on 5/26/17.
 */

public interface MainView {

    void onFetched(List<ToDoModel> toDoModels);
}
