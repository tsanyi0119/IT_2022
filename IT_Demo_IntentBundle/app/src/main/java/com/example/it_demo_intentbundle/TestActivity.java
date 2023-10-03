package com.example.it_demo_intentbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        UserData userDataResponse = (UserData) getIntent().getSerializableExtra("valueUserData");
        Log.v("Test","姓名："+userDataResponse.getName()+" 年齡："+userDataResponse.getAge()+" 電話："+userDataResponse.getPhone());

    }
}