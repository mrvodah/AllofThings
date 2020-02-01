package com.example.project.retrofit;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

public class Interceptor implements okhttp3.Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        String token = "";

        Request newRequest = originalRequest.newBuilder()
                .header("X-Authorization", token)
                .build();

        return chain.proceed(newRequest);

//        Request original = chain.request();
//
//        Request request = original.newBuilder()
//                .header("User-Agent", "Your-App-Name")
//                .header("Accept", "application/vnd.yourapi.v1.full+json")
//                .method(original.method(), original.body())
//                .build();
//
//        return chain.proceed(request);
    }
}
