package com.example.it_demo_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = "Alex";
        sharedPreferences= getSharedPreferences("UserData",MODE_PRIVATE);
        sharedPreferences.edit()
                .putString("valueName",name)
                .commit();

//        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
//        sharedPreferences.edit()
//                .putString("valueName",name)
//                .commit();


        Intent intent = new Intent(MainActivity.this,TestActivity.class);
        startActivity(intent);
    }
}