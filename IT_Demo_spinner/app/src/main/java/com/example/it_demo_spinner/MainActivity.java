package com.example.it_demo_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);

        String[] district={"中區","東區","西區","南區","北區","西屯區",
                "南屯區","北屯區","豐原區","大里區","太平區","清水區",
                "沙鹿區","大甲區","東勢區","梧棲區","烏日區","神岡區",
                "大肚區","大雅區","后里區","霧峰區","潭子區","龍井區",
                "外埔區","和平區","石岡區","大安區","新社區"};
        ArrayAdapter<String>districtAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.spinner_selected_shape,district);
        districtAdapter.setDropDownViewResource(R.layout.spinner_dropdown_shape);
        spinner.setAdapter(districtAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText("您已選擇："+district[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}