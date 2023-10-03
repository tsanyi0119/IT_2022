package com.example.it_demo_seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //當拖動SeekBar造成SeekBar位置改變時執行
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //按下SeekBar時執行
                Toast.makeText(MainActivity.this,"按下SeekBar提示",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //放開SeekBar時執行
                Toast.makeText(MainActivity.this,"放開SeekBar提示",Toast.LENGTH_LONG).show();
            }
        });
    }
}