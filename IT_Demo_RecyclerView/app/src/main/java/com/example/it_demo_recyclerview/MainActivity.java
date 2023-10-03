package com.example.it_demo_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    StudentData student;
    List<StudentData> studentDataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //建立假資料
        for(int i = 0;i<30;i++){
            student =  new StudentData(i+1,
                                "09"+String.format("%08d",i+1),
                                "XXX");
            studentDataList.add(student);
        }

        recyclerView = findViewById(R.id.recyclerView);
        //設置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //設置RecyclerViewAdapter與傳入要顯示的資料
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerViewAdapter.setStudentData(studentDataList);
        recyclerView.setAdapter(recyclerViewAdapter);
        //添加底線樣式
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}