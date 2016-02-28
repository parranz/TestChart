package com.asraii.testchart;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.db.chart.Tools;
import com.db.chart.model.LineSet;
import com.db.chart.model.Point;
import com.db.chart.view.AxisController;
import com.db.chart.view.LineChartView;
import com.db.chart.view.Tooltip;
import com.db.chart.view.animation.Animation;
import com.db.chart.view.animation.easing.BounceEase;
import com.db.chart.view.animation.easing.LinearEase;
import com.db.chart.view.animation.easing.QuartEase;

import java.util.ArrayList;
import java.util.Date;

import lecho.lib.hellocharts.util.ChartUtils;

public class WilliamsChartActivity extends AppCompatActivity {


    private final String[] mLabels= {"Jan", "Fev", "Mar", "Apr", "Jun", "May", "Jul", "Aug", "Sep"};
    private final float[][] mValues = {{3.5f, 4.7f, 4.3f, 8f, 6.5f, 9.9f, 7f, 8.3f, 7.0f},
            {4.5f, 2.5f, 2.5f, 9f, 4.5f, 9.5f, 5f, 8.3f, 1.8f}};

    private Tooltip mTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_williams_chart);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//       setSupportActionBar(toolbar);

        LineChartView chartView = (LineChartView) this.findViewById(R.id.willchart);
/*
        ArrayList<String> mLabels = new ArrayList<>();
        float[] mValues = new float[Chart.values.length];
        for (int i = 0; i < Chart.values.length; ++i) {
            mLabels.add(new Date((long) Chart.values[i][0]).toString());
            mValues[i] = Chart.values[i][1];
        }
        */
        //LineSet lineSet = new LineSet(mLabels.toArray(new String[mLabels.size()]), mValues);
        LineSet lineSet = new LineSet();

        for (int i = 0; i < Chart.values.length; ++i) {
            lineSet.addPoint(new Point("n",Chart.values[i][1]));

        }

        // Style dots
        //lineSet.setDots(true);
        lineSet.setVisible(true);
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
                .setThickness(4);
        chartView.addData(lineSet);

        // Chart
        chartView
                .setYLabels(AxisController.LabelPosition.NONE)
                .setLabelsColor(Color.parseColor("#6a84c3"))
                .setXAxis(false)
                .setYAxis(false);
        chartView.show();


   Animation a = new Animation(1000);
        a.setEasing(new BounceEase());

        chartView.show(a);
/*SS
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
