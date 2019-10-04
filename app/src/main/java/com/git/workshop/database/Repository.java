package com.git.workshop.database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.git.workshop.R;
import com.git.workshop.database.model.User;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class Repository extends AppCompatActivity {
    private static final String TAG = Repository.class.getName();
    private AppDatabase db;
    private EditText firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repository);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "workshop-db").build();

        firstName = (EditText) findViewById(R.id.fName);
        lastName = (EditText) findViewById(R.id.lName);

        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        User user = new User();
                        user.firstName = firstName.getText().toString();
                        user.lastName = lastName.getText().toString();

                        db.userDao().insertAll(user);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });

        Button queryButton = (Button) findViewById(R.id.query);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        List<User> users = db.userDao().getAll();
                        for (User user: users) {
                            Log.d(TAG, user.firstName + " " + user.lastName);
                        }
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });
    }
}
