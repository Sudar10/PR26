package com.example.pr26;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Идентификатор уведомления
   int NOTIFY_ID = 101;

    // Идентификатор канала
   String CHANNEL_ID = "Cat channel";

    // CharSequence CHANNEL_NAME = getString(R.string.channel_name);
    // int importance = NotificationManager.IMPORTANCE_LOW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        NotificationManager manager = (NotificationManager)
        getSystemService((NOTIFICATION_SERVICE));
        Notification.Builder builder =
                new Notification.Builder(MainActivity.this);
                        builder
                                .setSmallIcon(R.drawable.baseline_scatter_plot_24)
                                .setContentTitle("Напоминание")
                                .setContentText("Пора покормить кота");


            NotificationChannel channel = new NotificationChannel("1", "my_chanel", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel((channel));
            builder.setChannelId("1");


       manager.notify(NOTIFY_ID, builder.build());

    }


}