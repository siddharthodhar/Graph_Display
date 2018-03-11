package com.siddhartho.graph;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Double y, x;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        GraphView graph1 = (GraphView) findViewById(R.id.graph1);
        GraphView graph2 = (GraphView) findViewById(R.id.graph2);
        GraphView graph3 = (GraphView) findViewById(R.id.graph3);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        x = -10.0;
        for (int i = 0; i < 1000; i++){
            x = x + 0.1;
            y = Math.sin(x);
            series.appendData(new DataPoint(x, y), true, 1000);
        }
        graph.setTitle("Sine Wave");
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series.setColor(Color.BLACK);
        graph.getViewport().setBackgroundColor(Color.BLUE);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-15);
        graph.getViewport().setMaxX(15);
        graph.getViewport().setScalable(true);
        graph.addSeries(series);

        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>();
        x = -10.0;
        for (int i = 0; i < 1000; i++){
            x = x + 0.1;
            y = -0.0000156 * Math.pow((x - 5), 4) + 4.5;
            series1.appendData(new DataPoint(x, y), true, 1000);
        }
        graph1.setTitle("Polynomial Wave");
        graph1.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph1.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph1.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series1.setColor(Color.YELLOW);
        graph1.getViewport().setBackgroundColor(Color.BLUE);
        graph1.getViewport().setXAxisBoundsManual(true);
        graph1.getViewport().setMinX(-15);
        graph1.getViewport().setMaxX(15);
        graph1.getViewport().setScalable(true);
        graph1.addSeries(series1);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>();
        x = -10.0;
        for (int i = 0; i < 1000; i++){
            x = x + 0.1;
            y = Math.sinh(x);
            series2.appendData(new DataPoint(x, y), true, 1000);
        }
        graph2.setTitle("Sine Hyperbolic Wave");
        graph2.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph2.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph2.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series2.setColor(Color.RED);
        graph2.getViewport().setBackgroundColor(Color.BLUE);
        graph2.getViewport().setXAxisBoundsManual(true);
        graph2.getViewport().setMinX(-15);
        graph2.getViewport().setMaxX(15);
        graph2.getViewport().setScalable(true);
        graph2.addSeries(series2);

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>();
        x = -10.0;
        for (int i = 0; i < 1000; i++){
            x = x + 0.1;
            y = Math.cos(x);
            series3.appendData(new DataPoint(x, y), true, 1000);
        }
        graph3.setTitle("Cosine Wave");
        graph3.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph3.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph3.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series3.setColor(Color.GREEN);
        graph3.getViewport().setBackgroundColor(Color.BLUE);
        graph3.getViewport().setXAxisBoundsManual(true);
        graph3.getViewport().setMinX(-15);
        graph3.getViewport().setMaxX(15);
        graph3.getViewport().setScalable(true);
        graph3.addSeries(series3);
    }
}
