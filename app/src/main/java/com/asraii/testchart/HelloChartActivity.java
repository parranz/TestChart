package com.asraii.testchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lecho.lib.hellocharts.formatter.SimpleLineChartValueFormatter;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

public class HelloChartActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_chart);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    /**
     * A fragment containing a line chart.
     */
    public static class PlaceholderFragment extends Fragment {

        private LineChartView chart;
        private LineChartData data;

        private boolean hasAxes = true;
        private boolean hasAxesNames = false;
        private boolean hasLines = true;
        private boolean hasPoints = false;
        private ValueShape shape = ValueShape.CIRCLE;
        private boolean isFilled = false;
        private boolean hasLabels = true;
        private boolean isCubic = false;
        private boolean hasLabelForSelected = false;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            setHasOptionsMenu(true);
            View rootView = inflater.inflate(R.layout.fragment_hellochart, container, false);

            chart = (LineChartView) rootView.findViewById(R.id.hellochart);

            generateData();

            // Disable viewpirt recalculations, see toggleCubic() method for more info.
            chart.setViewportCalculationEnabled(false);

            return rootView;
        }

        private void generateData() {

            Chart chartValues = new Chart();
            List<Line> lines = new ArrayList<Line>();
            List<PointValue> values = new ArrayList<PointValue>();
            List<AxisValue> axisValues = new ArrayList<AxisValue>();
            for (int i = 0; i < Chart.values.length; ++i) {
                PointValue point = new PointValue(i, Chart.values[i][1]);
                point.setLabel(new Date((long) Chart.values[i][0]).toString());
                values.add(point);
            }
            Line line = new Line(values);
            line.setColor(Color.LTGRAY);
            line.setShape(shape);
            line.setCubic(isCubic);
            line.setFilled(isFilled);
            line.setHasLabels(hasLabels);
            line.setHasLabelsOnlyForSelected(hasLabelForSelected);
            line.setHasLines(hasLines);
            line.setHasPoints(hasPoints);
            line.setFormatter(new SimpleLineChartValueFormatter(2));
            line.setStrokeWidth(1);
            line.setHasLabelsOnlyForSelected(true);
            lines.add(line);

            PointValue p = new PointValue(chartValues.getMinIndex(), chartValues.getMinValue());
            values = new ArrayList<PointValue>();
            values.add(p);
            line = new Line(values);
            line.setHasLabels(false);
            line.setHasLabelsOnlyForSelected(true);
            line.setHasLines(false);
            line.setHasPoints(true);
            line.setPointColor(Color.WHITE);
            line.setFormatter(new SimpleLineChartValueFormatter(2));
            line.setStrokeWidth(1);
            line.setHasLabelsOnlyForSelected(true);
            lines.add(line);

            p = new PointValue(chartValues.getMaxIndex(), chartValues.getMaxValue());
            values = new ArrayList<PointValue>();
            values.add(p);
            line = new Line(values);
            line.setHasLabels(false);
            line.setHasLabelsOnlyForSelected(true);
            line.setHasLines(false);
            line.setHasPoints(true);
            line.setPointColor(Color.WHITE);
            line.setFormatter(new SimpleLineChartValueFormatter(2));
            line.setStrokeWidth(1);
            line.setHasLabelsOnlyForSelected(true);
            lines.add(line);

            data = new LineChartData(lines);

            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
            data.setBaseValue(Float.NEGATIVE_INFINITY);
            data.setAxisXBottom(new Axis(axisValues));
            chart.setLineChartData(data);
            chart.setBackgroundColor(Color.DKGRAY);
            chart.setZoomEnabled(true);

            AlphaAnimation trans = new AlphaAnimation(0,100);
            trans.setDuration(600);
            trans.setInterpolator(new AccelerateInterpolator(1.0f));
            chart.startAnimation(trans);
            /*
            chart.overridePendingTransition(R.anim.animation_enter,
                    R.anim.animation_leave);*/
        }


    }
}