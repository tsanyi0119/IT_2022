package com.example.it_demo_datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //日期選擇監聽事件
    DatePickerDialog.OnDateSetListener datePickerListener;
    //時間選擇監聽事件
    TimePickerDialog.OnTimeSetListener timePickerListener;

    //日期選擇視窗
    DatePickerDialog datePickerDialog;
    //時間選擇視窗
    TimePickerDialog timePickerDialog;

    //用於存放時間資訊
    Calendar calendar;
    //格式化
    SimpleDateFormat sdfDate,sdfTime;

    TextView textView;
    Button button_Date,button_Time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button_Date = findViewById(R.id.button_Date);
        button_Time = findViewById(R.id.button_Time);

        //日期格式 yyyyMMdd
        sdfDate = new SimpleDateFormat("yyyyMMdd",Locale.TAIWAN);

        //時間格式 hhMM
        sdfTime = new SimpleDateFormat("HH:mm",Locale.TAIWAN);

        //讓calendar抓取當前時間
        calendar = Calendar.getInstance();

//--------------------------------------------------------------------------------------------------------

        /** 日期選擇監聽 **/
        datePickerListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,day);

                textView.setText(sdfDate.format(calendar.getTime()) +" "+ sdfTime.format(calendar.getTime()));
            }
        };

        /** 日期選擇視窗 **/
        datePickerDialog = new DatePickerDialog(MainActivity.this,
                datePickerListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

//--------------------------------------------------------------------------------------------------------

        /** 時間選擇監聽 **/
        timePickerListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hour);
                calendar.set(Calendar.MINUTE,minute);

                textView.setText(sdfDate.format(calendar.getTime()) +" "+ sdfTime.format(calendar.getTime()));

            }
        };

        /** 時間選擇視窗 **/
        timePickerDialog = new TimePickerDialog(MainActivity.this,
                timePickerListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true);

//--------------------------------------------------------------------------------------------------------

        button_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        button_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

    }
}