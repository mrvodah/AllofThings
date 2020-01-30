package com.example.project.memoryleak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project.R;

public class MemoryLeakDestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak_destination);
    }
}
