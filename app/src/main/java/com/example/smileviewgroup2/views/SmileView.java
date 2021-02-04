package com.example.smileviewgroup2.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.example.smileviewgroup2.R;

public class SmileView extends View {
    float smileX;
    float smileY;
    Bitmap smile;
    public SmileView(Context context) {
        super(context);
        smile = BitmapFactory.decodeResource(getResources(), R.drawable.smile);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        smileX = w / 2F - smile.getWidth() / 2F;
        smileY = h / 2F - smile.getHeight() / 2F;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(0,0,255);
        canvas.drawBitmap(smile, smileX, smileY, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int dx = event.getX() < smileX ? -1 : 1;
            int dy = event.getY() < smileY ? -1 : 1;
            smileX += dx * 20;
            smileY = smileY + dy * 20;
            invalidate();
            return true;
        }
        return false;
    }
}
