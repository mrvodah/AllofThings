package com.example.project.retrofit.config;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project.R;
import com.example.project.retrofit.NetworkModule;
import com.example.project.retrofit.RetrofitCallBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        NetworkModule.getService().getConfig()
                .enqueue(new RetrofitCallBack<Config>(this, new RetrofitCallBack.Listener<Config>() {
                    @Override
                    public void onResponse(Call<Config> call, Response<Config> response) {

                    }
                }));
    }
}
