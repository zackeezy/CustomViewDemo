package edu.harding.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View {

    private ShapeDrawable mShape;

    private int mLeft = 10;

    private int mTop = 10;

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mShape = new ShapeDrawable(new OvalShape());
        Paint paint = mShape.getPaint();
        paint.setColor(Color.rgb(0,255,0));     //green
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Custom Drawing. canvas = drawable surface.

        canvas.drawRGB(220,220,220);

        //Set shape's location
        mShape.setBounds(mLeft, mTop, mLeft + 100, mTop + 150);

        //determines visible attributes of what's being painted
        Paint paint = new Paint();

        paint.setColor(Color.rgb(255,0,0));
        paint.setStrokeWidth(10);
        paint.setAlpha(50);

        Paint greenLine = new Paint();

        greenLine.setColor(Color.rgb(0,255,0));
        greenLine.setStrokeWidth(10);

        canvas.drawLine(0, 0, canvas.getWidth(), canvas.getHeight(), paint);
        canvas.drawLine(canvas.getWidth(), 0, 0, canvas.getHeight(), greenLine);

        Paint blue = new Paint();
        blue.setColor(Color.argb(60,0,0,255));

        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2,
                canvas.getWidth() < canvas.getHeight() ? canvas.getWidth() / 2 : canvas.getHeight() / 2, blue);

        //display shape
        mShape.draw(canvas);
    }

    public void update(){
        mLeft++;
        mTop++;
    }

    public void draw(){
        //Redraws by triggering the onDraw
        invalidate();
    }
}
