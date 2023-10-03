package com.example.it_demo_snackbartoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);

//        //Snackbar一般顯示
//        Snackbar.make(findViewById(R.id.linearLayout),
//                "這是 Snackbar", Snackbar.LENGTH_LONG).show();

//        //Snackbar有按鈕的顯示
//        Snackbar.make(findViewById(R.id.linearLayout), "這是 Snackbar", Snackbar.LENGTH_LONG)
//                .setAction("OK", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //點擊時要執行的動作
//                    }
//                })
//                .setActionTextColor(Color.BLUE) //可以指定文字顏色
//                .show();

        Toast.makeText(MainActivity.this, "這是 Toast", Toast.LENGTH_SHORT).show();
    }
}