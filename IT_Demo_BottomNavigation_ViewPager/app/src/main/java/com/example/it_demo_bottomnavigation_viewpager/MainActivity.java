package com.example.it_demo_bottomnavigation_viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    PageAdapter pageAdapter;
    ViewPager2 viewPager;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPage);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        pageAdapter = new PageAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager.setAdapter(pageAdapter);

        //viewPager
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.na_home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.na_setting);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.na_other);
                        break;
                }
            }
        });

        //bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.na_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.na_setting:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.na_other:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

    }
}