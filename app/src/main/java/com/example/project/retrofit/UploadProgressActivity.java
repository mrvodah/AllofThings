package com.example.project.retrofit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.project.MainActivity;
import com.example.project.R;
import com.google.gson.JsonObject;
import com.jaiselrahman.filepicker.activity.FilePickerActivity;
import com.jaiselrahman.filepicker.config.Configurations;
import com.jaiselrahman.filepicker.model.MediaFile;

import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadProgressActivity extends AppCompatActivity implements ProgressRequestBody.UploadCallbacks {

    private static final String TAG = "UploadProgressActivity";
    private static final int IMAGE_REQUEST_CODE = 1;

    ProgressDialog progressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_progress);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadProgressActivity.this, FilePickerActivity.class);
                intent.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
                        .setCheckPermission(true)
                        .setShowImages(false)
                        .setShowVideos(true)
                        .setShowAudios(false)
                        .setMaxSelection(1)
                        .setSkipZeroSizeFiles(true)
                        .build());
                startActivityForResult(intent, IMAGE_REQUEST_CODE);
            }
        });

        createDialog();
    }

    private void createDialog() {
        progressdialog = new ProgressDialog(UploadProgressActivity.this);

        progressdialog.setIndeterminate(false);

        progressdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressdialog.setCancelable(false);

        progressdialog.setMax(100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            ArrayList<MediaFile> files = data.getParcelableArrayListExtra(FilePickerActivity.MEDIA_FILES);
            for (MediaFile file : files) {
                rqUploadFile(81, file);
            }
        }
    }

    private void rqUploadFile(int discussionId, MediaFile mediaFile) {
        progressdialog.show();
        File file = new File(mediaFile.getPath());
        RequestBody id = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(discussionId));
        RequestBody email = RequestBody.create(MediaType.parse("text/plain"), "minhadmin@edulive.net");
        RequestBody token = RequestBody.create(MediaType.parse("text/plain"), "web-5e01bac59909a");

        ProgressRequestBody fileBody = new ProgressRequestBody(file, mediaFile.getMimeType(), this);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file_upload", mediaFile.getName(), fileBody);

        NetworkModule.getService().uploadFileDiscussion(id, body, email, token)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Toast.makeText(UploadProgressActivity.this, "done", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(UploadProgressActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onProgressUpdate(int percentage) {
        Log.d(TAG, "onProgressUpdate: " + percentage);
        progressdialog.setProgress(percentage);
    }

    @Override
    public void onError() {
        progressdialog.dismiss();
//        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFinish() {
        progressdialog.dismiss();
//        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
    }
}
