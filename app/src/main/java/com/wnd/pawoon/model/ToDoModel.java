package com.wnd.pawoon.model;

/**
 * Created by Wandy on 5/25/17.
 */

public final class ToDoModel {
    public final long userId;
    public final long id;
    public final String title;
    public final boolean completed;

    public ToDoModel(long userId, long id, String title, boolean completed){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
}