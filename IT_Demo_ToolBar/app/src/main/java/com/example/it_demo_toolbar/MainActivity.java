package com.example.it_demo_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation);
        imageView = findViewById(R.id.imageView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.na_home:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_android));
                        break;
                    case R.id.na_setting:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_accessibility));
                        break;
                    case R.id.na_other:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_account_circle));
                        break;
                }
                return true;
            }
        });
    }
}