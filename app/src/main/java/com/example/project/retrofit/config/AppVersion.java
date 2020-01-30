package com.example.project.retrofit.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppVersion {

    @SerializedName("android")
    @Expose
    private String android;
    @SerializedName("ios")
    @Expose
    private String ios;

    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public String getIos() {
        return ios;
    }

    public void setIos(String ios) {
        this.ios = ios;
    }

    @Override
    public String toString() {
        return "AppVersion{" +
                "android='" + android + '\'' +
                ", ios='" + ios + '\'' +
                '}';
    }
}
