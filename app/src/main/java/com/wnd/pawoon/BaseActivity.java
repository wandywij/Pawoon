package com.wnd.pawoon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wnd.pawoon.controller.FlowController;

/**
 * Created by Wandy on 6/24/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private FlowController flowController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreate();
    }

    private FlowController getFlowController() {
        if (flowController == null) {
            flowController = new FlowController(this);
        }
        return flowController;
    }

    abstract void onCreate();

    protected void navigateTo(Class<? extends AppCompatActivity> target) {
        getFlowController().navigateTo(target);
    }

}
