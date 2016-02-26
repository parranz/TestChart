package com.asraii.testchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.db.chart.Tools;
import com.db.chart.model.LineSet;
import com.db.chart.model.Point;
import com.db.chart.view.AxisController;
import com.db.chart.view.LineChartView;
import com.db.chart.view.animation.Animation;
import com.db.chart.view.animation.easing.BounceEase;

import java.util.ArrayList;
import java.util.Date;

import lecho.lib.hellocharts.util.ChartUtils;

public class WilliamsChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_williams_chart);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//       setSupportActionBar(toolbar);

        LineChartView chartView = (LineChartView) this.findViewById(R.id.willchart);
        ArrayList<String> mLabels = new ArrayList<>();
        float[] mValues = new float[DarwinexChart.portfolioChart.length];
        for (int i = 0; i < DarwinexChart.portfolioChart.length; ++i) {
            mLabels.add(new Date((long) DarwinexChart.portfolioChart[i][0]).toString());
            mValues[i] = DarwinexChart.portfolioChart[i][1];
        }
        LineSet lineSet = new LineSet(mLabels.toArray(new String[mLabels.size()]), mValues);

        /*
        for (int i = 0; i < DarwinexChart.portfolioChart.length; ++i) {
            lineSet.addPoint(new Point(new Date((long)DarwinexChart.portfolioChart[i][0]).toString(),DarwinexChart.portfolioChart[i][1]));

        }*/

        // Style dots
        //lineSet.setDots(true);

        lineSet.setDotsColor(ChartUtils.COLORS[1]);
        lineSet.setDotsRadius(2);
        lineSet.setDotsStrokeThickness(2);
        lineSet.setDotsStrokeColor(ChartUtils.COLORS[2]);

        // Style line;
        lineSet.setThickness(1);
        lineSet.setColor(ChartUtils.COLORS[3]);

        // Style background fill
        lineSet.setFill(ChartUtils.COLORS[4]);

        // Style type
//        lineSet.setDashed(boolean);
//        lineSet.setSmooth(boolean);

        ;

        lineSet.setColor(Color.parseColor("#b3b5bb"))
                .setFill(Color.parseColor("#2d374c"))
                .setDotsColor(Color.parseColor("#ffc755"))
                .setThickness(4)
                .endAt(6);
        chartView.addData(lineSet);

        // Chart
        chartView.setBorderSpacing(Tools.fromDpToPx(15))
                .setAxisBorderValues(0, 20)
                .setYLabels(AxisController.LabelPosition.NONE)
                .setLabelsColor(Color.parseColor("#6a84c3"))
                .setXAxis(false)
                .setYAxis(false);
/*
        mBaseAction = action;
        Runnable chartAction = new Runnable() {
            @Override
            public void run() {
                mBaseAction.run();
                mTip.prepare(mChart.getEntriesArea(0).get(3), mValues[0][3]);
                mChart.showTooltip(mTip, true);
            }
        };

        Animation anim = new Animation()
                .setEasing(new BounceEase())
                .setEndAction(chartAction);

        chartView.show(anim);
*/
    }

}
