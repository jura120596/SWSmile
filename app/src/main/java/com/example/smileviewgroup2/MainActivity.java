package com.example.smileviewgroup2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smileviewgroup2.views.SmileSurfaceView;
import com.example.smileviewgroup2.views.SmileView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SmileSurfaceView(this));
    }
}
