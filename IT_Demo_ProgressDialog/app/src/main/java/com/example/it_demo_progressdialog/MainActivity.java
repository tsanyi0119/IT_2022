package com.example.it_demo_progressdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        //設定標題
        progressDialog.setTitle("工作執行");
        //設定訊息
        progressDialog.setMessage("更新資料中...");
        //設定是否可以點擊對話框之外來取消ProgressDialog，true表示可以取消；false表示不行取消
        progressDialog.setCancelable(false);
        //顯示ProgressDialog對話框
        progressDialog.show();
    }
}