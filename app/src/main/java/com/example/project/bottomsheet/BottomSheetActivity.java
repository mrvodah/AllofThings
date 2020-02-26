package com.example.project.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.project.R;

import butterknife.internal.Utils;

public class BottomSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        InputBottomSheetFragment edtComment = new InputBottomSheetFragment();
        edtComment.show(this.getSupportFragmentManager(), InputBottomSheetFragment.class.getSimpleName());
    }

    public void onShowBottomSheet(View view) {
        InputBottomSheetFragment edtComment = new InputBottomSheetFragment();
        edtComment.show(this.getSupportFragmentManager(), InputBottomSheetFragment.class.getSimpleName());
    }
}
