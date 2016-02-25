package com.asraii.testchart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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
        private boolean hasPoints = true;
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

            List<Line> lines = new ArrayList<Line>();
            List<PointValue> values = new ArrayList<PointValue>();
            List<AxisValue> axisValues = new ArrayList<AxisValue>();
            for (int i = 0; i < DarwinexChart.portfolioChart.length; ++i) {
                PointValue point = new PointValue(i, DarwinexChart.portfolioChart[i][1]);
                point.setLabel(new Date((long)DarwinexChart.portfolioChart[i][0]).toString());
                values.add(point);
//                AxisValue axisValue = new AxisValue(DarwinexChart.portfolioChart[i][0]);
//                axisValue.setLabel(new Date((long)DarwinexChart.portfolioChart[i][0]).toString());
//                axisValues.add(axisValue);
            }
            Line line = new Line(values);
            line.setColor(ChartUtils.COLORS[1]);
            line.setShape(shape);
            line.setCubic(isCubic);
            line.setFilled(isFilled);
            line.setHasLabels(hasLabels);
            line.setHasLabelsOnlyForSelected(hasLabelForSelected);
            line.setHasLines(hasLines);
            line.setHasPoints(hasPoints);
            line.setFormatter(new SimpleLineChartValueFormatter(2));
            line.setHasLabelsOnlyForSelected(true);
            lines.add(line);

            data = new LineChartData(lines);

            /*
            if (hasAxes) {
                Axis axisX = new Axis();
                Axis axisY = new Axis().setHasLines(false);
                if (hasAxesNames) {
                    axisX.setName("Axis X");
                    axisY.setName("Axis Y");
                }
                data.setAxisXBottom(axisX);
                data.setAxisYLeft(axisY);
            } else {
                data.setAxisXBottom(null);
                data.setAxisYLeft(null);
            }*/
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
            data.setBaseValue(Float.NEGATIVE_INFINITY);
            data.setAxisXBottom(new Axis(axisValues));
            chart.setLineChartData(data);
            chart.setZoomEnabled(true);

        }


    }
}