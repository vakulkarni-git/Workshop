package com.git.workshop.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.git.workshop.R;

import androidx.appcompat.app.AppCompatActivity;

public class PreferencesExample extends AppCompatActivity {
    private static final String TAG = PreferencesExample.class.getName();
    private SharedPreferences preferences;
    private String preferencesName = "WorkshopPreferences";
    private int requestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);

        Log.d(TAG, "onCreate()");

        preferences = this.getSharedPreferences(preferencesName, MODE_PRIVATE);

        Button testButton = (Button) findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreferencesExample.this, UserInput.class);
                startActivityForResult(intent, requestCode);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.requestCode) {
            if (resultCode == RESULT_OK) {
                String fullName = preferences.getString(UserInput.FIRST_NAME, "") + " " +
                        preferences.getString(UserInput.LAST_NAME, "");
                Toast.makeText(this, fullName,
                        Toast.LENGTH_SHORT).show();
            }
        }
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
