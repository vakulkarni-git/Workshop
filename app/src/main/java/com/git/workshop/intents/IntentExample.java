package com.git.workshop.intents;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import com.git.workshop.R;

import androidx.appcompat.app.AppCompatActivity;

public class IntentExample extends AppCompatActivity {
    private static final String TAG = IntentExample.class.getName();
    private int requestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent);

        Log.d(TAG, "onCreate()");

        builtInActivities();
    }

    private void builtInActivities() {
        Button browserButton = findViewById(R.id.browserButton);
        browserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.git.edu"));
                startActivity(intent);
            }
        });

        Button makeCalls = findViewById(R.id.makeCalls);
        makeCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:+917890645321"));
                startActivity(intent);
            }
        });

        Button showMap = findViewById(R.id.showMap);
        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:15.8497,74.4977"));
                startActivity(intent);
            }
        });

        Button chooseContact = findViewById(R.id.chooseContact);
        chooseContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                startActivityForResult(intent, requestCode);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.requestCode) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getData().toString(),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(data.getData().toString()));
                startActivity(intent);
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
