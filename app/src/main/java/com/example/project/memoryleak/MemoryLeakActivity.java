package com.example.project.memoryleak;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import com.example.project.R;

public class MemoryLeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsyncWork();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MemoryLeakActivity.this, MemoryLeakDestinationActivity.class));
                finish();
            }
        });

    }

    @SuppressLint("StaticFieldLeak")
    void startAsyncWork() {
        // This runnable is an anonymous class and therefore has a hidden reference to the outer
        // class MainActivity. If the activity gets destroyed before the thread finishes (e.g. rotation),
        // the activity instance will leak.
        Runnable work = new Runnable() {
            @Override public void run() {
                // Do some slow work in background
                SystemClock.sleep(20000);
            }
        };
        new Thread(work).start();
    }

}
