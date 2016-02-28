package com.asraii.testchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class AChartActivity extends AppCompatActivity {

    public static final String TYPE = "type";
    private XYMultipleSeriesDataset mDataset = getDemoDataset();
    private XYMultipleSeriesRenderer mRenderer = getDemoRenderer();
    private GraphicalView mChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achart);
        setRendererStyling();
        if (mChartView == null) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.achartLayout);
            mChartView = ChartFactory.getLineChartView(this, mDataset,
                    mRenderer);
            mRenderer.setSelectableBuffer(100);
            layout.addView(mChartView, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        } else
            mChartView.repaint();
    }

    private void setRendererStyling() {
        mRenderer.setApplyBackgroundColor(false);
//        mRenderer.setBackgroundColor(Color.argb(100, 50, 50, 50));
        mRenderer.setAxisTitleTextSize(16);
        mRenderer.setChartTitleTextSize(20);
        mRenderer.setLabelsTextSize(15);
        mRenderer.setLegendTextSize(15);
        mRenderer.setMargins(new int[] { 20, 30, 15, 0 });
        mRenderer.setZoomButtonsVisible(true);
        mRenderer.setPointSize(10);
    }

    private XYMultipleSeriesDataset getDemoDataset() {

        Chart chart = new Chart();
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();

        XYSeries firstSeries = new XYSeries(null);
        for (int i = 0; i < chart.getmValues().length; i++)
            firstSeries.add(i,chart.getmValues()[i]);

        dataset.addSeries(firstSeries);

        XYSeries secondSeries = new XYSeries(null);
        secondSeries.add(chart.getMinIndex(), chart.getMinValue());
        dataset.addSeries(secondSeries);

        XYSeries thirdSeries = new XYSeries(null);
        thirdSeries.add(chart.getMaxIndex(), chart.getMaxValue());
        dataset.addSeries(thirdSeries);

        XYSeries fourthSeries = new XYSeries(null);
        for (int i = chart.getMinIndex(); i <= chart.getMaxIndex(); i++)
            fourthSeries.add(i,chart.getmValues()[i]);

        dataset.addSeries(fourthSeries);


        return dataset;
    }

    private XYMultipleSeriesRenderer getDemoRenderer() {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setMargins(new int[]{20, 30, 15, 0});
        renderer.setPanEnabled(false);
        renderer.setYLabels(0);
        renderer.setZoomEnabled(true);
        renderer.setChartTitle("");
        renderer.setXTitle("");
        renderer.setYTitle("");
        renderer.setShowAxes(false);
        renderer.setShowGrid(false);
        renderer.setShowLabels(false);
        renderer.setShowLegend(false);
        renderer.setBackgroundColor(Color.DKGRAY);
        renderer.setZoomEnabled(false);
        renderer.setShowTickMarks(false);

        XYSeriesRenderer r = new XYSeriesRenderer();
        r.setColor(Color.LTGRAY);
        r.setFillPoints(false);

        renderer.addSeriesRenderer(r);

        r = new XYSeriesRenderer();
        r.setPointStyle(PointStyle.CIRCLE);
        r.setColor(Color.WHITE);
        r.setFillPoints(true);
        renderer.addSeriesRenderer(r);
        renderer.addSeriesRenderer(r);

        r = new XYSeriesRenderer();
        r.setColor(Color.BLUE);
        r.setFillPoints(false);
        renderer.addSeriesRenderer(r);

        return renderer;
    }
}
