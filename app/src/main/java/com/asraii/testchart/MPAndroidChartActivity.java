package com.asraii.testchart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MPAndroidChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp_android_chart);

        LineChart lineChart = (LineChart) findViewById(R.id.mpchart);
        // creating list of entry
        ArrayList<Entry> entries = new ArrayList<>();
/*
        for (int i=0;i<DarwinexChart.portfolioChart.length;i++) {
            float[] value = DarwinexChart.portfolioChart[i];
            entries.add(new Entry(value[1], value[0]));
        }*/
        
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));

        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        // creating labels
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        LineData data = new LineData(labels, dataset);
        lineChart.setData(data); // set the data and list of lables into chart

        lineChart.setDescription("Description");
        dataset.setDrawCubic(false);

        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
    }

}
