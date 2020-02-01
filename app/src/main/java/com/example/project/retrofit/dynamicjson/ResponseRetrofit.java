package com.example.project.retrofit.dynamicjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResponseRetrofit {

    public void retrofitClient(){
//        Gson userDeserializer = new GsonBuilder().setLenient().registerTypeAdapter(ResponseWrapper.class,
//                new UserResponseDeserializer()).create();
//
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("base_url")
//                .addConverterFactory(GsonConverterFactory.create(userDeserializer))
//                .build();
//
//
//        UserService request = retrofit.create(UserService.class);
//        Call<ResponseWrapper> call1=request.listAllUsers();
//
//        call1.enqueue(new Callback<ResponseWrapper>() {
//            @Override
//            public void onResponse(Call<ResponseWrapper> call, Response<ResponseWrapper> response) {
//                ResponseWrapper responseWrapper=response.body();
//            }
//
//            @Override
//            public void onFailure(Call<ResponseWrapper> call, Throwable t) {
//            }
//        });
    }

}
