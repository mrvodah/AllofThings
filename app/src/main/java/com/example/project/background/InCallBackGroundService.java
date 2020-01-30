package com.example.project.background;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.project.MainActivity;
import com.example.project.R;

import java.util.Objects;

import butterknife.internal.Utils;

public class InCallBackGroundService extends Service {
    private WindowManager mWindowManager;
    private View mChatHeadView;
    private TextView tvTimmer;
    private int isLiveRoomFree = 0;

    public InCallBackGroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAG", "onBind: " + System.currentTimeMillis());
        startTime = SystemClock.uptimeMillis();
        startMins = intent.getIntExtra("currenttime",0);
        customHandler.postDelayed(updateTimerThread, 0);
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Inflate the chat head layout we created
        mChatHeadView = LayoutInflater.from(this).inflate(R.layout.layout_chat_head, null);
//        int uiOptions =  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
//        mChatHeadView.setSystemUiVisibility(uiOptions);
        RelativeLayout parentView = mChatHeadView.findViewById(R.id.parent_chat_heat_view);
        tvTimmer = mChatHeadView.findViewById(R.id.chat_heat_title);
        parentView.setOnClickListener(view -> openLiveRoom(isLiveRoomFree));
        tvTimmer.setOnClickListener(view -> openLiveRoom(isLiveRoomFree));

        final WindowManager.LayoutParams params;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(getApplicationContext()),
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                            | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                            | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                            | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    PixelFormat.TRANSLUCENT);

        } else {
            params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(getApplicationContext()),
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                            | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                            | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                            | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    PixelFormat.TRANSLUCENT);
        }

//        //Add the view to the window.
//        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
//                WindowManager.LayoutParams.MATCH_PARENT,
//                Utils.getStatusBarHeight(getApplicationContext()),
//                WindowManager.LayoutParams.TYPE_PHONE,
//                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                PixelFormat.TRANSLUCENT);

        //Specify the chat head position
//Initially view will be added to top-left corner
        params.gravity = Gravity.TOP | Gravity.START;
        params.x = 0;
        params.y = 0;

        //Add the view to the window
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Objects.requireNonNull(mWindowManager).addView(mChatHeadView, params);


//….
//….
    }

    public int getStatusBarHeight(@NonNull Context context) {
        // status bar height
        int statusBarHeight = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    private void openLiveRoom(int value){
        int requestID = (int) System.currentTimeMillis();
        Log.d("TAG", "onResumeService: " + System.currentTimeMillis());
        if(value == 0){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            PendingIntent pendingIntent =
                    PendingIntent.getActivity(getApplicationContext(), requestID, intent, 0);
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
            stopSelf();
        }
        else{
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            PendingIntent pendingIntent =
                    PendingIntent.getActivity(getApplicationContext(), requestID, intent, 0);
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
            stopSelf();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy: " + System.currentTimeMillis());
        if (mChatHeadView != null) mWindowManager.removeView(mChatHeadView);
    }

    private long startTime = 0L;
    private int startMins = 0;
    private final Handler customHandler = new Handler();
    private final Runnable updateTimerThread = new Runnable() {
        public void run() {
            long timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            long timeSwapBuff = 0L;
            long updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = startMins + secs / 60;
            int hours = mins / 60;
            secs = secs % 60;
            tvTimmer.setText("Edulive Group Learning call   " + String.format("%02d", hours) + ":"
                    + String.format("%02d", mins - hours * 60));
            customHandler.postDelayed(this, 0);
        }
    };
}
