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
        GraphView graph4 = (GraphView) findViewById(R.id.graph4);
        GraphView graph5 = (GraphView) findViewById(R.id.graph5);
        GraphView graph6 = (GraphView) findViewById(R.id.graph6);
        GraphView graph1 = (GraphView) findViewById(R.id.graph1);
        GraphView graph7 = (GraphView) findViewById(R.id.graph7);
        GraphView graph8 = (GraphView) findViewById(R.id.graph8);
        GraphView graph9 = (GraphView) findViewById(R.id.graph9);
        GraphView graph2 = (GraphView) findViewById(R.id.graph2);
        GraphView graph10 = (GraphView) findViewById(R.id.graph10);
        GraphView graph11 = (GraphView) findViewById(R.id.graph11);
        GraphView graph12 = (GraphView) findViewById(R.id.graph12);
        GraphView graph3 = (GraphView) findViewById(R.id.graph3);
        GraphView graph13 = (GraphView) findViewById(R.id.graph13);
        GraphView graph14 = (GraphView) findViewById(R.id.graph14);
        GraphView graph15 = (GraphView) findViewById(R.id.graph15);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
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
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(90);
//        graph.getViewport().setScalable(true);
        graph.addSeries(series);

        LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.cos(x);
            series4.appendData(new DataPoint(x, y), true, 1000);
        }
        graph4.setTitle("Cosine Wave");
        graph4.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph4.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph4.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series4.setColor(Color.GREEN);
        graph4.getViewport().setBackgroundColor(Color.BLUE);
        graph4.getViewport().setXAxisBoundsManual(true);
        graph4.getViewport().setMinX(0);
        graph4.getViewport().setMaxX(90);
//        graph4.getViewport().setScalable(true);
        graph4.addSeries(series4);

        LineGraphSeries<DataPoint> series5 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series5.appendData(new DataPoint(x, y), true, 1000);
        }
        graph5.setTitle("Sine Wave");
        graph5.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph5.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph5.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series5.setColor(Color.BLACK);
        graph5.getViewport().setBackgroundColor(Color.BLUE);
        graph5.getViewport().setXAxisBoundsManual(true);
        graph5.getViewport().setMinX(0);
        graph5.getViewport().setMaxX(90);
//        graph5.getViewport().setScalable(true);
        graph5.addSeries(series5);

        LineGraphSeries<DataPoint> series6 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.cos(x);
            series6.appendData(new DataPoint(x, y), true, 1000);
        }
        graph6.setTitle("Cosine Wave");
        graph6.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph6.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph6.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series6.setColor(Color.GREEN);
        graph6.getViewport().setBackgroundColor(Color.BLUE);
        graph6.getViewport().setXAxisBoundsManual(true);
        graph6.getViewport().setMinX(0);
        graph6.getViewport().setMaxX(90);
//        graph6.getViewport().setScalable(true);
        graph6.addSeries(series6);

        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>();
        x = -10.0;
        for (int i = 0; i < 1000; i++) {
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
        graph1.getViewport().setMinX(-10);
        graph1.getViewport().setMaxX(15);
//        graph1.getViewport().setScalable(true);
        graph1.addSeries(series1);

        LineGraphSeries<DataPoint> series7 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.cos(x);
            series7.appendData(new DataPoint(x, y), true, 1000);
        }
        graph7.setTitle("Cosine Wave");
        graph7.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph7.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph7.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series7.setColor(Color.GREEN);
        graph7.getViewport().setBackgroundColor(Color.BLUE);
        graph7.getViewport().setXAxisBoundsManual(true);
        graph7.getViewport().setMinX(0);
        graph7.getViewport().setMaxX(90);
//        graph7.getViewport().setScalable(true);
        graph7.addSeries(series7);

        LineGraphSeries<DataPoint> series8 = new LineGraphSeries<DataPoint>();
        x = -10.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = -0.0000156 * Math.pow((x - 5), 4) + 4.5;
            series8.appendData(new DataPoint(x, y), true, 1000);
        }
        graph8.setTitle("Polynomial Wave");
        graph8.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph8.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph8.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series8.setColor(Color.YELLOW);
        graph8.getViewport().setBackgroundColor(Color.BLUE);
        graph8.getViewport().setXAxisBoundsManual(true);
        graph8.getViewport().setMinX(-10);
        graph8.getViewport().setMaxX(15);
//        graph8.getViewport().setScalable(true);
        graph8.addSeries(series8);

        LineGraphSeries<DataPoint> series9 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.cos(x);
            series9.appendData(new DataPoint(x, y), true, 1000);
        }
        graph9.setTitle("Cosine Wave");
        graph9.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph9.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph9.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series9.setColor(Color.GREEN);
        graph9.getViewport().setBackgroundColor(Color.BLUE);
        graph9.getViewport().setXAxisBoundsManual(true);
        graph9.getViewport().setMinX(0);
        graph9.getViewport().setMaxX(90);
//        graph9.getViewport().setScalable(true);
        graph9.addSeries(series9);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>();
        x = -10.0;
        for (int i = 0; i < 1000; i++) {
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
        graph2.getViewport().setMinX(-10);
        graph2.getViewport().setMaxX(15);
//        graph2.getViewport().setScalable(true);
        graph2.addSeries(series2);

        LineGraphSeries<DataPoint> series10 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series10.appendData(new DataPoint(x, y), true, 1000);
        }
        graph10.setTitle("Sine Wave");
        graph10.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph10.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph10.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series10.setColor(Color.BLACK);
        graph10.getViewport().setBackgroundColor(Color.BLUE);
        graph10.getViewport().setXAxisBoundsManual(true);
        graph10.getViewport().setMinX(0);
        graph10.getViewport().setMaxX(90);
//        graph10.getViewport().setScalable(true);
        graph10.addSeries(series10);

        LineGraphSeries<DataPoint> series11 = new LineGraphSeries<DataPoint>();
        x = -10.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.sinh(x);
            series11.appendData(new DataPoint(x, y), true, 1000);
        }
        graph11.setTitle("Sine Hyperbolic Wave");
        graph11.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph11.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph11.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series11.setColor(Color.RED);
        graph11.getViewport().setBackgroundColor(Color.BLUE);
        graph11.getViewport().setXAxisBoundsManual(true);
        graph11.getViewport().setMinX(-10);
        graph11.getViewport().setMaxX(15);
//        graph11.getViewport().setScalable(true);
        graph11.addSeries(series11);

        LineGraphSeries<DataPoint> series12 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series12.appendData(new DataPoint(x, y), true, 1000);
        }
        graph12.setTitle("Sine Wave");
        graph12.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph12.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph12.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series12.setColor(Color.BLACK);
        graph12.getViewport().setBackgroundColor(Color.BLUE);
        graph12.getViewport().setXAxisBoundsManual(true);
        graph12.getViewport().setMinX(0);
        graph12.getViewport().setMaxX(90);
//        graph12.getViewport().setScalable(true);
        graph12.addSeries(series12);

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
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
        graph3.getViewport().setMinX(0);
        graph3.getViewport().setMaxX(90);
//        graph3.getViewport().setScalable(true);
        graph3.addSeries(series3);

        LineGraphSeries<DataPoint> series13 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series13.appendData(new DataPoint(x, y), true, 1000);
        }
        graph13.setTitle("Sine Wave");
        graph13.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph13.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph13.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series13.setColor(Color.BLACK);
        graph13.getViewport().setBackgroundColor(Color.BLUE);
        graph13.getViewport().setXAxisBoundsManual(true);
        graph13.getViewport().setMinX(0);
        graph13.getViewport().setMaxX(90);
//        graph13.getViewport().setScalable(true);
        graph13.addSeries(series13);

        LineGraphSeries<DataPoint> series14 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.cos(x);
            series14.appendData(new DataPoint(x, y), true, 1000);
        }
        graph14.setTitle("Cosine Wave");
        graph14.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph14.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph14.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series14.setColor(Color.GREEN);
        graph14.getViewport().setBackgroundColor(Color.BLUE);
        graph14.getViewport().setXAxisBoundsManual(true);
        graph14.getViewport().setMinX(0);
        graph14.getViewport().setMaxX(90);
//        graph14.getViewport().setScalable(true);
        graph14.addSeries(series14);

        LineGraphSeries<DataPoint> series15 = new LineGraphSeries<DataPoint>();
        x = 0.0;
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series15.appendData(new DataPoint(x, y), true, 1000);
        }
        graph15.setTitle("Sine Wave");
        graph15.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph15.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph15.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        series15.setColor(Color.BLACK);
        graph15.getViewport().setBackgroundColor(Color.BLUE);
        graph15.getViewport().setXAxisBoundsManual(true);
        graph15.getViewport().setMinX(0);
        graph15.getViewport().setMaxX(90);
//        graph15.getViewport().setScalable(true);
        graph15.addSeries(series15);
    }
}
