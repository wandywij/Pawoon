package com.wnd.pawoon.presenter;

/**
 * Created by Wandy on 5/26/17.
 */

public interface BasePresenter<T> {
    void onAttachView(T t);
    void onDetachview(T t);
}
