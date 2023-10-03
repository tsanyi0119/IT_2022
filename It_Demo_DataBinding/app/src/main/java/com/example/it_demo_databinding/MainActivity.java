package com.example.it_demo_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.it_demo_databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //這邊作為Data來源
    MainModel mainModel;
    //ActivityMainBinding由系統建立
    //如果沒有可能是忘記 Make Project => 上方導航列 -> Build -> Make Project
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainModel = new MainModel();
        //將View與Model綁定
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.setValue(mainModel);
        mainBinding.setView(this);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        mainBinding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //內容變化前
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //內容變化中
                mainBinding.setValue(mainModel);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //內如變化後
                mainBinding.setValue(mainModel);
            }
        });
    }
    public void noParametricOnClick(){
        Log.v("noParametric","無傳值");
    }
    public void haveParametricOnClick(String name){
        Log.v("haveParametric","有傳值 : "+name);
    }
}