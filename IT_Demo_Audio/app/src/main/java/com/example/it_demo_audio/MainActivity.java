package com.example.it_demo_audio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    AudioManager audioManager;
    SeekBar seekBar;
    Button btn_up,btn_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        seekBar = findViewById(R.id.seekBar);
        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);

        initSeekBar();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //當拖動SeekBar或造成SeekBar位置改變時執行
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress,AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //按下SeekBar時執行
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //放開SeekBar時執行
            }
        });

        //增加音量
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC
                        ,AudioManager.ADJUST_RAISE,AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI);
                initSeekBar();
            }
        });

        //降低音量
        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC
                        ,AudioManager.ADJUST_LOWER,AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI);
                initSeekBar();
            }
        });

    }

    //獲取當前音量與最大音量
    private void initSeekBar() {
        //最大音量
        int MaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //目前音量
        int CurrentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBar.setMax(MaxVolume);
        seekBar.setProgress(CurrentVolume);
    }
}