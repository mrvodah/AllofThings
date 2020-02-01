package com.example.project.background;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.project.BuildConfig;
import com.example.project.MainActivity;
import com.example.project.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BackgroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);
        ButterKnife.bind(this);

//        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                Uri.parse("package:" + getPackageName()));
//        startActivityForResult(intent, 1);


    }

    @Override
    protected void onStop() {
        super.onStop();
        startActivity();
//        startService(new Intent(this, InCallBackGroundService.class));
    }

    private void startActivity() {

        Uri sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.thi_thoi);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build();

            String CHANNEL_ID = BuildConfig.APPLICATION_ID.concat("_notification_id");
            String CHANNEL_NAME = BuildConfig.APPLICATION_ID.concat("_notification_name");
            assert notificationManager != null;

            NotificationChannel mChannel = notificationManager.getNotificationChannel(CHANNEL_ID);
            if (mChannel == null) {
                mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
                mChannel.setSound(sound, attributes);
                notificationManager.createNotificationChannel(mChannel);
            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);

            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(getString(R.string.app_name))
                    .setContentText(getString(R.string.login))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_CALL)
                    .setContentIntent(openParkingViolationScreen(1))
                    .setAutoCancel(true)
                    .setOngoing(true);

            Notification notification = builder.build();
            notificationManager.notify(1, notification);
        }

    }

    private PendingIntent openParkingViolationScreen(int notificationId) {
        Intent fullScreenIntent = new Intent(this, MainActivity.class);
        return PendingIntent.getActivity(this, 113, fullScreenIntent, 0);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
    }
}
