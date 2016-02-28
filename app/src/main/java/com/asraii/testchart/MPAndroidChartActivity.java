package com.asraii.testchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MPAndroidChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp_android_chart);

        Entry min = new Entry (Chart.values[0][1],0);
        Entry max = new Entry (Chart.values[0][1],0);

        LineChart lineChart = (LineChart) findViewById(R.id.mpchart);
        // creating list of entry
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        for (int i=0;i< Chart.values.length;i++) {
            float[] value = Chart.values[i];
            Entry entry = new Entry(value[1], i);
            if (value[1]<min.getVal())
                min = entry;
            if (value[1]>=max.getVal())
                max = entry;
            entries.add(entry);
            labels.add(new Date((long) Chart.values[i][0]).toString());
        }

        //dataset of the first line
        LineDataSet dataset = new LineDataSet(entries, null);
        dataset.setDrawCubic(false);
        dataset.setDrawCircles(false);
        dataset.setDrawValues(false);
        dataset.disableDashedLine();
        dataset.disableDashedHighlightLine();
        dataset.setHighlightEnabled(false);
        dataset.setColor(Color.LTGRAY);

        //dataset of the second line
        LineDataSet datasetFill = new LineDataSet(entries.subList(min.getXIndex(),max.getXIndex()+1), null);
        datasetFill.setDrawCubic(false);
        datasetFill.setDrawCircles(false);
        datasetFill.setDrawValues(false);
        datasetFill.disableDashedLine();
        datasetFill.disableDashedHighlightLine();
        datasetFill.setHighlightEnabled(false);
        datasetFill.setColor(Color.BLUE);

        //dataset of the min dot
        ArrayList<Entry> minDot = new ArrayList<>();
        minDot.add(min);
        LineDataSet minDotDataset = new LineDataSet(minDot, null);
        minDotDataset.setDrawCubic(false);
        minDotDataset.setDrawCircles(true);
        minDotDataset.setCircleColor(Color.WHITE);
        minDotDataset.setDrawValues(false);
        minDotDataset.disableDashedLine();
        minDotDataset.disableDashedHighlightLine();
        minDotDataset.setHighlightEnabled(false);

        //dataset of the max dot
        ArrayList<Entry> maxDot = new ArrayList<>();
        maxDot.add(max);
        LineDataSet maxDotDataset = new LineDataSet(maxDot, null);
        maxDotDataset.setDrawCubic(false);
        maxDotDataset.setDrawCircles(true);
        maxDotDataset.setDrawValues(false);
        maxDotDataset.disableDashedLine();
        maxDotDataset.disableDashedHighlightLine();
        maxDotDataset.setHighlightEnabled(false);
        maxDotDataset.setCircleColor(Color.WHITE);

        List<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataset);
        dataSets.add(minDotDataset);
        dataSets.add(maxDotDataset);
        dataSets.add(datasetFill);
        LineData data = new LineData(labels, dataSets);

        lineChart.setData(data); // set the data and list of lables into chart
        lineChart.setDrawGridBackground(false);
        lineChart.setBackgroundColor(Color.DKGRAY);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getXAxis().setEnabled(false);
        lineChart.animateX(500);
        lineChart.getLegend().setEnabled(false);
        //dataset.setColors(ColorTemplate.COLORFUL_COLORS);
    }

}
