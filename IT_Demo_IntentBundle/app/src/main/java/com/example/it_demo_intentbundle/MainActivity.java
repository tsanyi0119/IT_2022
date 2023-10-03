package com.example.it_demo_intentbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserData userData = new UserData("Allan","20","0900000000");
                Bundle bundle = new Bundle();
                bundle.putSerializable("valueUserData", userData);

                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
    }
}