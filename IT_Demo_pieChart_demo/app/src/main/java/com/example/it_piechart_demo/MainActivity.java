package com.example.it_piechart_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI(){
        pieChart = findViewById(R.id.pieChart);
        setPieChart();
    }

    private void setPieChart(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(10f, "A"));
        entries.add(new PieEntry(20f, "B"));
        entries.add(new PieEntry(30f, "C"));
        entries.add(new PieEntry(40f, "D"));

        PieDataSet dataSet = new PieDataSet(entries, "PieChartData");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(12f);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);

        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("PieChart");
        pieChart.animateY(1000);
    }
}