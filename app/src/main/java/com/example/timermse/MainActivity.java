package com.example.timermse;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.timermse.R;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseing;
    private boolean working;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("TIME :: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {

                }
            }
        });
    }

    public void startChronometer(View v) {
        if (!working) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseing);
            chronometer.start();
            working = true;
        }
    }

    public void pauseChronometer(View v) {
        if (working) {
            chronometer.stop();
            pauseing = SystemClock.elapsedRealtime() - chronometer.getBase();
            working = false;
        }
    }

    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseing = 0;
    }
}