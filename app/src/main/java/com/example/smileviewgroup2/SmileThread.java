package com.example.smileviewgroup2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.example.smileviewgroup2.views.SmileSurfaceView;

public class SmileThread extends Thread {
    private SurfaceHolder holder;
    private SmileSurfaceView smileSurfaceView;
    private volatile boolean run = true;
    private Bitmap smile;
    private float touchX, touchY, oldX, oldY;
    public SmileThread(SmileSurfaceView smileSurfaceView, SurfaceHolder holder) {
        this.holder = holder;
        this.smileSurfaceView = smileSurfaceView;
        smile = BitmapFactory.decodeResource(
                smileSurfaceView.getContext().getResources(),
                R.drawable.smile
        );
    }
    @Override
    public void run() {
        while (run) {
            Canvas canvas = holder.lockCanvas();
            if (canvas != null) {
                try {
                    if (!smileSurfaceView.start ||
                        oldX <= touchX && (oldX + smile.getWidth()) > touchX &&
                        oldY <= touchY && (oldY + smile.getHeight()) > touchY
                        || (touchX == 0 && touchY == 0)
                    ) {
                            canvas.drawRGB(0, 255, 0);
                            oldX = touchX;
                            oldY = touchY;
                        canvas.drawBitmap(smile, touchX, touchY, null);
                    }
                    Paint paint = new Paint();
                    paint.setTextSize(80);
                    paint.setColor(Color.GREEN);
                    canvas.drawRect(0, canvas.getHeight() - 200, canvas.getWidth(), canvas.getHeight(), paint);

                    paint.setColor(Color.BLACK);
                    canvas.drawText("old:" + oldX +"," + oldY+ "   " + "Touch:" + touchX +"," +touchY,
                            0, canvas.getHeight() - 100, paint);
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
