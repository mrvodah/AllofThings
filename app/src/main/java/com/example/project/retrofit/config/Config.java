package com.example.project.retrofit.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config {
    @SerializedName("exam")
    @Expose
    private SubConfig subConfig;
    @SerializedName("appVersion")
    @Expose
    private AppVersion appVersion;

    public SubConfig getSubConfig() {
        return subConfig;
    }

    public void setSubConfig(SubConfig subConfig) {
        this.subConfig = subConfig;
    }

    public AppVersion getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(AppVersion appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public String toString() {
        return "Config{" +
                "subConfig=" + subConfig +
                ", appVersion=" + appVersion +
                '}';
    }
}
