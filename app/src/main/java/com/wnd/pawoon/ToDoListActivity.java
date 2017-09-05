package com.wnd.pawoon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wnd.pawoon.di.SharedPreferenceComponent;

import javax.inject.Inject;

public class ToDoListActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;

    private SharedPreferenceComponent sharedPreferenceComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);



        //sharedPreferences.edit().putString("hellow", "lorem ipsum");
        //sharedPreferences.edit().commit();

        //Log.d(ToDoListActivity.class.getSimpleName(), sharedPreferences.getString("hellow", "empty string"));
    }
}
