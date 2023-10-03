package com.example.it_demo_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_changeA,btn_changeB;
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_changeA = findViewById(R.id.btn_changeA);
        btn_changeB = findViewById(R.id.btn_changeB);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        //獲取FragmentManager使用beginTransaction()，對關聯的Fragment進行一系列編輯操作
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,fragmentA,"A").commit();

        btn_changeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //replace()方法，用於切換Fragment。須注意並不會保存上一個Fragment。
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragmentA,"A").commit();
            }
        });
        btn_changeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //replace()方法，用於切換Fragment。須注意並不會保存上一個Fragment。
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragmentB,"B").commit();
            }
        });
    }
}