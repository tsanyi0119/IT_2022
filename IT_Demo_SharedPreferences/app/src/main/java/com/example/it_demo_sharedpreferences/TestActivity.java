package com.example.it_demo_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        String nameeResponse = getSharedPreferences("UserData",MODE_PRIVATE)
                .getString("valueName","");

//        String nameResponse = getPreferences(MODE_PRIVATE)
//                .getString("valueName","");
        Log.v("Test",nameeResponse);
    }
}