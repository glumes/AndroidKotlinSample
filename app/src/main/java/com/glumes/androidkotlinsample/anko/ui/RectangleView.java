package com.glumes.androidkotlinsample.anko.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * @Author glumes
 */

public class RectangleView extends View {

    public int size ;
    public Paint mPaint;

    public RectangleView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(Color.BLUE);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, size, mPaint);
    }

}
