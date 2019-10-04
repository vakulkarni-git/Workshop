package com.git.workshop.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.git.workshop.R;

import androidx.appcompat.app.AppCompatActivity;

public class UserInput extends AppCompatActivity {
    private static final String TAG = UserInput.class.getName();
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String preferencesName = "WorkshopPreferences";

    public static String FIRST_NAME = "firstName";
    public static String LAST_NAME = "lastName";

    private EditText firstName;
    private EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_input);

        preferences = this.getSharedPreferences(preferencesName, MODE_PRIVATE);
        editor = preferences.edit();

        firstName = (EditText) findViewById(R.id.fName);
        lastName = (EditText) findViewById(R.id.lName);

        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferences();
                Intent data = new Intent();
                setResult(RESULT_OK, data);
                finish();
            }
        });

        Log.d(TAG, "onCreate()");
    }

    private void savePreferences() {
        editor.putString(FIRST_NAME, firstName.getText().toString());
        editor.putString(LAST_NAME, lastName.getText().toString());
        editor.commit();
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
