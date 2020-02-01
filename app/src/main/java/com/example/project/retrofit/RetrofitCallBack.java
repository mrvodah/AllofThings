package com.example.project.retrofit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.example.project.R;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCallBack<T> implements Callback<T> {

    private static final String TAG = "RetrofitCallBack";
    private static final String E_SESSION_EXPIRED = "E_SESSION_EXPIRED";
    private static final String E_UPDATE_VERSION_REQUIRED = "E_UPDATE_VERSION_REQUIRED";
    private Context context;
    private Listener<T> listener;
    private ListenerWithFailed<T> listenerWithFailed;

    private int currentIndex = 0;
    private int maxIndex = 0;

    public RetrofitCallBack(Context context, Listener<T> listener) {
        this.context = context;
        this.listener = listener;
    }

    public RetrofitCallBack(Context context, ListenerWithFailed<T> listenerWithFailed) {
        this.context = context;
        this.listenerWithFailed = listenerWithFailed;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        try {
            if (response.errorBody() != null) {

            } else {
                String jsonResponse = new Gson().toJson(response.body());
                JSONObject jsonObject = new JSONObject(jsonResponse);
                Log.d(TAG, "onResponse:1 " + response.body().toString());
                Log.d(TAG, "onResponse:2 " + jsonObject.toString());

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    public interface Listener<T> {

        void onResponse(Call<T> call, Response<T> response);
    }

    public interface ListenerWithFailed<T> {

        void onResponse(Call<T> call, Response<T> response);

        void onFailure(Call<T> call, Throwable t);
    }

}
