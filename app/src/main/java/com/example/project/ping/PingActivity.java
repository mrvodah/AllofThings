package com.example.project.ping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.retrofit.UploadProgressActivity;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PingActivity extends AppCompatActivity {

    private static final String TAG = "PingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping);

        findViewById(R.id.button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(PingActivity.this, UploadProgressActivity.class);
//                        startActivity(intent);
//                        finish();


                    }
                });

        startService(new Intent(this, PingService.class));

//        AlarmManager am=(AlarmManager)PingActivity.this.getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(PingActivity.this, PingService.class);
//        PendingIntent pi = PendingIntent.getService(PingActivity.this, 0, intent, 0);
//        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1000 * 5), pi);

//        ScheduledExecutorService scheduleTaskExecutor = Executors.newScheduledThreadPool(5);
//
//        // This schedule a runnable task every 2 minutes
//        scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
//            public void run() {
//                Log.d(TAG, "run: it still run");
//            }
//        }, 0, 10, TimeUnit.SECONDS);



    }
}
