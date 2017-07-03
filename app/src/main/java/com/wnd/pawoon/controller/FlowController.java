package com.wnd.pawoon.controller;

import android.app.Activity;
import android.content.Intent;

import com.wnd.pawoon.ToDoListActivity;

/**
 * Created by Wandy on 6/24/17.
 */

public class FlowController {

    private Activity activity;

    public FlowController(Activity activity) {
        this.activity = activity;
    }

    public void navigateTo(Class<? extends Activity> target) {
        Intent i = new Intent(this.activity, target);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);
    }
}
