package com.wnd.pawoon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wnd.pawoon.di.ApplicationComponent;

public class ToDoListActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);


        sharedPreferences = ((PawoonApplication) getApplication()).getAppComponent().sharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("cemungudh", "eaphh");
        editor.commit();

        Log.d(ToDoListActivity.class.getSimpleName(), sharedPreferences.getString("cemungudh", "empty string"));
    }
}
