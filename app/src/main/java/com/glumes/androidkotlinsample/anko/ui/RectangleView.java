package com.glumes.androidkotlinsample.anko.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * @Author glumes
 */

public class RectangleView extends View {

    public static final String TAG = "RectangleView";

    public int size = 10;

    public RectangleView(Context context) {
        this(context, null);
        Log.d(TAG, "1");

    }

    public RectangleView(Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
        Log.d(TAG, "2");

    }

    public RectangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "3");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(Color.BLUE);
        Log.d(TAG, "onDraw");
    }

    public void setSize(int size) {
        this.size = size;
    }
}
