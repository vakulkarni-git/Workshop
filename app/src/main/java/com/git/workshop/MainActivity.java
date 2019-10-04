package com.git.workshop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.git.workshop.database.Repository;
import com.git.workshop.intents.IntentExample;
import com.git.workshop.lifecycle.Lifecycle;
import com.git.workshop.notifications.NotificationActivity;
import com.git.workshop.preferences.PreferencesExample;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate()");

        Button execute = (Button) findViewById(R.id.execute);
        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For Lifecycle
                //Intent intent = new Intent(MainActivity.this, Lifecycle.class);

                // For Intents
                //Intent intent = new Intent(MainActivity.this, IntentExample.class);

                // For Preferences
                //Intent intent = new Intent(MainActivity.this, PreferencesExample.class);

                // For Database
                //Intent intent = new Intent(MainActivity.this, Repository.class);

                Intent intent = new Intent(MainActivity.this, Lifecycle.class);
                startActivity(intent);
            }
        });
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
