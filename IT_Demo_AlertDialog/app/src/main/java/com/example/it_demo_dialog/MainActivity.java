package com.example.it_demo_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1;
    AlertDialog.Builder alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button);
        alertDialog = new AlertDialog.Builder(MainActivity.this);

        /** Dialog設定 **/
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //設定標題
                alertDialog.setTitle("顯示按鈕");
                //設定訊息
                alertDialog.setMessage("顯示所有按鈕");
                //設定是否可以點擊對話框之外來取消Dialog，true表示可以取消；false表示不行取消
                alertDialog.setCancelable(false);

                //右邊按鈕
                alertDialog.setPositiveButton("右邊", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                //左邊按鈕
                alertDialog.setNeutralButton("左邊", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                //中間按鈕
                alertDialog.setNegativeButton("中間", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                alertDialog.show();

                //原本是Builder狀態要透過create轉成Dialog，在show出來
                //但是show()這個方法裡面會自動將Builder轉成Dialog，所以可以省略
                //需要特別注意這邊的show()是AlertDialog.Builder的，與AlertDialog的show不同
//                AlertDialog dialog = alertDialog.create();
//                dialog.show();
            }
        });

    }
}