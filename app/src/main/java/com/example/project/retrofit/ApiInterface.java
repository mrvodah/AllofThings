package com.example.project.retrofit;

import com.example.project.retrofit.config.Config;
import com.example.project.retrofit.config.ConfigResponse;
import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @Multipart
    @POST("uploadFileDiscussion")
    Call<JsonObject> uploadFileDiscussion(@Part("discussionId") RequestBody discussion_id, @Part MultipartBody.Part file,
                                                  @Part("email") RequestBody email, @Part("token") RequestBody token);

    @GET("config")
    Call<ConfigResponse> getConfig();
}
