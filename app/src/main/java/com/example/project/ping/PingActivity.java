package com.example.project.ping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

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

    public static ScheduledExecutorService scheduleTaskExecutor;

    private final AppLifecycleListener appLifecycleListener = new AppLifecycleListener();

    private boolean isInBackground = false;

    public static ScheduledExecutorService getInstance() {
        scheduleTaskExecutor = Executors.newScheduledThreadPool(5);

        return scheduleTaskExecutor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping);

//        findViewById(R.id.button)
//                .setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
////                        Intent intent = new Intent(PingActivity.this, UploadProgressActivity.class);
////                        startActivity(intent);
////                        finish();
//
//
//                    }
//                });

//        startService(new Intent(this, PingService.class));

        ProcessLifecycleOwner.get().getLifecycle().addObserver(appLifecycleListener);

//        AlarmManager am=(AlarmManager)PingActivity.this.getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(PingActivity.this, PingService.class);
//        PendingIntent pi = PendingIntent.getService(PingActivity.this, 0, intent, 0);
//        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1000 * 5), pi);

    }

    protected class AppLifecycleListener implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onMoveToForeground() {
            Log.d(TAG, "onMoveToForeground: ");

            if(scheduleTaskExecutor == null || scheduleTaskExecutor.isShutdown()){

                scheduleTaskExecutor = PingActivity.getInstance();

                scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
                    public void run() {
                        Log.d(TAG, "run: it still run");
                    }
                }, 0, 5, TimeUnit.SECONDS);
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onMoveToBackground() {
            Log.d(TAG, "onMoveToBackground: ");

            scheduleTaskExecutor.shutdown();
        }
    }

}
