package com.example.smileviewgroup2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class SmileThread extends Thread {
    private SurfaceHolder holder;
    private volatile boolean run = true;
    private Bitmap smile;
    private float touchX, touchY;
    public SmileThread(Context context, SurfaceHolder holder) {
        this.holder = holder;
        smile = BitmapFactory.decodeResource(
                context.getResources(),
                R.drawable.smile
        );
    }
    @Override
    public void run() {
        while (run) {
            Canvas canvas = holder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.drawRGB(0,255, 0);
                    canvas.drawBitmap(smile,touchX, touchY, null);
                } catch (Exception e) {
                }finally {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
    public void initStop() {
        run = false;
    }
    public void setXY(float x, float y) {
        touchX = x;
        touchY = y;
    }
}
