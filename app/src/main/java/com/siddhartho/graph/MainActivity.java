package com.siddhartho.graph;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.siddhartho.graph.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int REQUEST_PERMISSION_SAVE_IMAGE = 101, REQUEST_PERMISSION_SAVE_PDF = 102;
    private ActivityMainBinding binding;
    private Animator currentAnimator;
    private int shortAnimationDuration;
    private float startScale;
    private Rect startBounds;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");

        addSeriesToGraph();

        shortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);
    }

    private void addSeriesToGraph() {
        Log.d(TAG, "addSeriesToGraph() called");
        addSeriesToGraph(binding.graph, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph1, WaveType.POLYNOMIAL_WAVE);
        addSeriesToGraph(binding.graph2, WaveType.SINE_HYPERBOLIC_WAVE);
        addSeriesToGraph(binding.graph3, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph4, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph5, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph6, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph7, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph8, WaveType.POLYNOMIAL_WAVE);
        addSeriesToGraph(binding.graph9, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph10, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph11, WaveType.SINE_HYPERBOLIC_WAVE);
        addSeriesToGraph(binding.graph12, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph13, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph14, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph15, WaveType.SINE_WAVE);
    }

    private void addSeriesToExpandedGraph() {
        Log.d(TAG, "addSeriesToExpandedGraph() called");
        addSeriesToGraph(binding.graphExpanded, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph1Expanded, WaveType.POLYNOMIAL_WAVE);
        addSeriesToGraph(binding.graph2Expanded, WaveType.SINE_HYPERBOLIC_WAVE);
        addSeriesToGraph(binding.graph3Expanded, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph4Expanded, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph5Expanded, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph6Expanded, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph7Expanded, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph8Expanded, WaveType.POLYNOMIAL_WAVE);
        addSeriesToGraph(binding.graph9Expanded, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph10Expanded, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph11Expanded, WaveType.SINE_HYPERBOLIC_WAVE);
        addSeriesToGraph(binding.graph12Expanded, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph13Expanded, WaveType.SINE_WAVE);
        addSeriesToGraph(binding.graph14Expanded, WaveType.COSINE_WAVE);
        addSeriesToGraph(binding.graph15Expanded, WaveType.SINE_WAVE);
    }

    private void zoomIn() {
        Log.d(TAG, "zoomIn() called");
        if (currentAnimator != null) {
            currentAnimator.cancel();
        }
        addSeriesToExpandedGraph();

        startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        binding.container.getGlobalVisibleRect(startBounds);
        binding.containerExpanded.getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        binding.container.setAlpha(0f);
        binding.containerExpanded.setVisibility(View.VISIBLE);

        binding.containerExpanded.setPivotX(0f);
        binding.containerExpanded.setPivotY(0f);

        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(binding.containerExpanded, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(binding.containerExpanded, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(binding.containerExpanded, View.SCALE_X,
                        startScale, 1f))
                .with(ObjectAnimator.ofFloat(binding.containerExpanded,
                        View.SCALE_Y, startScale, 1f));
        set.setDuration(shortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                currentAnimator = null;
                menu.findItem(R.id.zoom).setTitle(R.string.zoom_out);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                currentAnimator = null;
            }
        });
        set.start();
        currentAnimator = set;
    }

    private void zoomOut() {
        Log.d(TAG, "zoomOut() called");
        final float startScaleFinal = startScale;

        if (currentAnimator != null) {
            currentAnimator.cancel();
        }

        AnimatorSet set = new AnimatorSet();
        set.play(ObjectAnimator
                .ofFloat(binding.containerExpanded, View.X, startBounds.left))
                .with(ObjectAnimator
                        .ofFloat(binding.containerExpanded,
                                View.Y, startBounds.top))
                .with(ObjectAnimator
                        .ofFloat(binding.containerExpanded,
                                View.SCALE_X, startScaleFinal))
                .with(ObjectAnimator
                        .ofFloat(binding.containerExpanded,
                                View.SCALE_Y, startScaleFinal));
        set.setDuration(shortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                binding.container.setAlpha(1f);
                binding.containerExpanded.setVisibility(View.GONE);
                currentAnimator = null;
                menu.findItem(R.id.zoom).setTitle(R.string.zoom_in);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                binding.container.setAlpha(1f);
                binding.containerExpanded.setVisibility(View.GONE);
                currentAnimator = null;
            }
        });
        set.start();
        currentAnimator = set;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu() called with: menu = [" + menu + "]");
        getMenuInflater().inflate(R.menu.main_menu, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected() called with: item = [" + item + "]");
        switch (item.getItemId()) {
            case R.id.zoom:
                if (item.getTitle().equals(getResources().getString(R.string.zoom_in))) zoomIn();
                else zoomOut();
                return true;
            case R.id.saveAsImage:
                saveAsImage();
                return true;
            case R.id.saveAsPdf:
                saveAsPdf();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult() called with: requestCode = [" + requestCode + "], permissions = [" + Arrays.toString(permissions) + "], grantResults = [" + Arrays.toString(grantResults) + "]");
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) switch (requestCode) {
            case REQUEST_PERMISSION_SAVE_IMAGE:
                saveAsImage();
                break;
            case REQUEST_PERMISSION_SAVE_PDF:
                saveAsPdf();
                break;
        }
    }

    private void addSeriesToGraph(GraphView graph, WaveType waveType) {
        Log.d(TAG, "addSeriesToGraph() called with: graph = [" + graph + "], waveType = [" + waveType + "]");
        graph.setTitle(waveType.getName());
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph.getViewport().setXAxisBoundsManual(true);
        if (waveType == WaveType.SINE_HYPERBOLIC_WAVE || waveType == WaveType.POLYNOMIAL_WAVE) {
            graph.getViewport().setMinX(-10);
            graph.getViewport().setMaxX(20);
        } else {
            graph.getViewport().setMinX(0);
            graph.getViewport().setMaxX(30);
        }
//        graph.getViewport().setScalable(true);
        graph.addSeries(getSeries(waveType));
    }

    private LineGraphSeries<DataPoint> getSeries(WaveType waveType) {
        Log.d(TAG, "getSeries() called with: waveType = [" + waveType + "]");
        double x = 0.0, y = 0.0;
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        for (int i = 0; i < 1000; i++) {
            x = x + 0.1;
            switch (waveType) {
                case SINE_WAVE:
                    y = Math.sin(x);
                    break;
                case COSINE_WAVE:
                    y = Math.cos(x);
                    break;
                case POLYNOMIAL_WAVE:
                    y = -0.0000156 * Math.pow((x - 5), 4) + 4.5;
                    break;
                case SINE_HYPERBOLIC_WAVE:
                    y = Math.sinh(x);
                    break;
            }
            series.appendData(new DataPoint(x, y), true, 1000);
        }
        series.setColor(waveType.getColor());
        return series;
    }

    private void saveAsPdf() {
        Log.d(TAG, "saveAsPdf() called");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                if (binding.containerExpanded.getVisibility() != View.VISIBLE)
                    zoomIn();

                Bitmap bitmap = getBitmapFromView(
                        binding.horizontalScrollContainer,
                        binding.horizontalScrollContainer.getChildAt(0).getHeight(),
                        binding.horizontalScrollContainer.getChildAt(0).getWidth());

                PdfDocument pdfDocument = new PdfDocument();
                PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(
                        bitmap.getWidth(),
                        bitmap.getHeight(),
                        1).create();
                PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                page.getCanvas().drawBitmap(bitmap, 0, 0, null);
                pdfDocument.finishPage(page);

                try {
                    FileOutputStream fos = provideFileOutputStream("PDF", getFilename(false));
                    if (fos != null) {
                        pdfDocument.writeTo(fos);
                        fos.flush();
                        fos.close();
                        Toast.makeText(this, R.string.toast_pdf_saved, Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "saveAsPdf: error = " + e.getMessage(), e);
                }
            } else
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_SAVE_PDF);
        } else Toast.makeText(this, R.string.toast_android_version, Toast.LENGTH_LONG).show();
    }

    private void saveAsImage() {
        Log.d(TAG, "saveAsImage() called");
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

            if (binding.containerExpanded.getVisibility() != View.VISIBLE)
                zoomIn();

            Bitmap bitmap = getBitmapFromView(
                    binding.horizontalScrollContainer,
                    binding.horizontalScrollContainer.getChildAt(0).getHeight(),
                    binding.horizontalScrollContainer.getChildAt(0).getWidth());

            try {
                FileOutputStream fos = provideFileOutputStream("Image", getFilename(true));
                if (fos != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();
                    Toast.makeText(this, R.string.toast_jpg_saved, Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                Log.e(TAG, "saveAsImage: error = " + e.getMessage(), e);
            }
        } else
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_SAVE_IMAGE);
    }

    private Bitmap getBitmapFromView(View view, int height, int width) {
        Log.d(TAG, "getBitmapFromView() called with: view = [" + view + "], height = [" + height + "], width = [" + width + "]");
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return bitmap;
    }

    private FileOutputStream provideFileOutputStream(String folderName, String filename) throws IOException {
        Log.d(TAG, "provideFileOutputStream() called with: folderName = [" + folderName + "], filename = [" + filename + "]");
        FileOutputStream fos = null;
        File root = new File(Environment.getExternalStorageDirectory(), "Graph/" + folderName);
        if (root.exists() || root.mkdirs()) {
            File file = new File(root, filename);
            if (file.createNewFile()) fos = new FileOutputStream(file);
        }
        return fos;
    }

    private String getFilename(boolean isImage) {
        Log.d(TAG, "getFilename() called with: isImage = [" + isImage + "]");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH);
        if (isImage)
            return format.format(Calendar.getInstance().getTime()) + " Graph.jpg";
        else
            return format.format(Calendar.getInstance().getTime()) + " Graph.pdf";
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed() called");
        if (binding.containerExpanded.getVisibility() == View.VISIBLE)
            zoomOut();
        else {
            finish();
            super.onBackPressed();
        }
    }

    private enum WaveType {

        SINE_WAVE("Sine Wave", Color.BLACK),
        COSINE_WAVE("Cosine Wave", Color.GREEN),
        POLYNOMIAL_WAVE("Polynomial Wave", Color.YELLOW),
        SINE_HYPERBOLIC_WAVE("Sine Hyperbolic Wave", Color.RED);

        private String name;
        private int color;

        WaveType(String name, int color) {
            this.name = name;
            this.color = color;
        }

        String getName() {
            return name;
        }

        int getColor() {
            return color;
        }
    }
}
