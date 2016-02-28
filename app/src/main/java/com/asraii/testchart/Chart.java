package com.asraii.testchart;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by patri on 25/02/16.
 */
public class Chart {

    private float minValue;
    private float maxValue;
    private int minIndex;
    private int maxIndex;
    private ArrayList<String> mLabels = new ArrayList<>();
    private float[] mValues = new float[Chart.values.length];

    public Chart() {
        prepareValues();
    }

    public final static float[][] values = new float[][]{
            {1441313940000f, 0.699992f},
            {1283374740000f, - 0.3f},
            {1434625799000f, 0.500000f},
            {1441400340000f, 0.999955f},
            {1441486740000f, 0.79994200f},
            {1441573140000f, 0.999942f},
            {1441659540000f, 0.999879f},
            {1441745940000f, 0.999822f},
            {1441832340000f, 0.499819f},
            {1441918740000f, 0.899654f},
            {1442005140000f, 0.999554f},
            {1442091540000f, 0.999552f},
            {1442177940000f, 0.99955f},
            {1442264340000f, 0.799588f},
            {1442350740000f, 0.999672f},
            {1442437140000f, 0.999648f},
            {1442523540000f, 0.999401f},
            {1442609940000f, 0.999635f}
    };

    private void prepareValues() {
        for (int i = 0; i < Chart.values.length; ++i) {
            mValues[i] = Chart.values[i][1];
            mLabels.add(new Date((long) Chart.values[i][0]).toString());
            if (mValues[1]<minValue) {
                minValue = mValues[i];
                minIndex = i;
            }
            if (mValues[1]>=maxValue) {
                maxValue = mValues[i];
                maxIndex = i;
            }
        }
    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinIndex() {
        return minIndex;
    }

    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public ArrayList<String> getmLabels() {
        return mLabels;
    }

    public void setmLabels(ArrayList<String> mLabels) {
        this.mLabels = mLabels;
    }

    public float[] getmValues() {
        return mValues;
    }

    public void setmValues(float[] mValues) {
        this.mValues = mValues;
    }
}

