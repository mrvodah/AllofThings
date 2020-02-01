package com.example.project.retrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;
import com.example.project.retrofit.config.ConfigResponse;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;

public class GetObjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_object);
        ButterKnife.bind(this);

    }

    private void getConfig() {
        NetworkModule.getService(this).getConfig()
                .enqueue(new RetrofitCallBack<ConfigResponse>(this, new RetrofitCallBack.Listener<ConfigResponse>() {
                    @Override
                    public void onResponse(Call<ConfigResponse> call, Response<ConfigResponse> response) {

                    }
                }));
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        getConfig();
    }
}
