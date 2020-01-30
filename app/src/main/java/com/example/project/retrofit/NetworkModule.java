package com.example.project.retrofit;

import android.content.Context;

public class NetworkModule {
    public NetworkModule() {
    }

    public static ApiInterface getService(Context context) {
        return RetrofitClient.getClient(context).create(ApiInterface.class);
    }
}
