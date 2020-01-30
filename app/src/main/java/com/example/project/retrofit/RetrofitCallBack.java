package com.example.project.retrofit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.project.retrofit.config.AppVersion;
import com.example.project.retrofit.config.Config;
import com.example.project.retrofit.config.SectionSentence;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

                if (listenerWithFailed != null) {
                    listenerWithFailed.onResponse(call, response);
                }
            } else {

                if(response.raw().cacheResponse() != null){
                    Log.d(TAG, "onResponse: cache");
                }

                if(response.raw().networkResponse() != null){
                    Log.d(TAG, "onResponse: network");
                }

                if (listener != null) {
                    listener.onResponse(call, response);
                }
                if (listenerWithFailed != null) {
                    listenerWithFailed.onResponse(call, response);
                }
            }
            Log.d(TAG, "onResponse: " + response.code());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (listenerWithFailed != null)
            listenerWithFailed.onFailure(call, t);
        Log.d(TAG, "onFailure: " + t.getMessage());
    }

    public interface Listener<T> {

        void onResponse(Call<T> call, Response<T> response);
    }

    public interface ListenerWithFailed<T> {

        void onResponse(Call<T> call, Response<T> response);

        void onFailure(Call<T> call, Throwable t);
    }

}
