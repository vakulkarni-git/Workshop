package com.git.workshop.lifecycle;

import android.os.Bundle;
import android.util.Log;

import com.git.workshop.R;

import androidx.appcompat.app.AppCompatActivity;

public class Lifecycle extends AppCompatActivity {
    private static final String TAG = Lifecycle.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle);

        Log.d(TAG, "onCreate()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }
}
