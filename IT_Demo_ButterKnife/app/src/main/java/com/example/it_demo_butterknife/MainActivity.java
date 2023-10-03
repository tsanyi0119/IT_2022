package com.example.it_demo_butterknife;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //宣告元件
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.imageView)
    ImageView imageView;

    //宣告資源
    @BindString(R.string.app_name) String appName;
    @BindColor(R.color.white) int color;
    @BindDrawable(R.drawable.ic_baseline_account_circle) Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //綁定View
        ButterKnife.bind(this);

        //設定元件TextView文字
        textView.setText("ButterKnife");

    }

    //點擊事件
    @OnClick(R.id.button)
    public void buttonOnclick(){
        Log.e("Tag","TestTest");
    }
}