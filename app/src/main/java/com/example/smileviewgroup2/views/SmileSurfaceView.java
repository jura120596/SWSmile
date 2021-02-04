package com.example.smileviewgroup2.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.smileviewgroup2.SmileThread;

public class SmileSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    SmileThread t;
    public SmileSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        t = new SmileThread(getContext(), holder);
        t.start();
        Thread t2 = new SmileThread(getContext(), holder);
        t2.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        t.setXY(event.getX(),  event.getY());
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
