package com.example.project;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import net.gotev.speech.Logger;

import leakcanary.LeakCanary;

public class AllofThings extends Application {

    public static AllofThings instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);

        Logger.setLogLevel(Logger.LogLevel.DEBUG);
    }
}
