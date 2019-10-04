package com.git.workshop.notifications;

import android.app.NotificationManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.git.workshop.R;

public class NotificationView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(getIntent().getExtras().getInt("notificationID"));
    }
}
