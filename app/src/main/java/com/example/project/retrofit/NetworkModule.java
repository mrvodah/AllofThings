package com.example.project.retrofit;

public class NetworkModule {
    public NetworkModule() {
    }

    public static ApiInterface getService() {
        return RetrofitClient.getClient().create(ApiInterface.class);
    }
}
