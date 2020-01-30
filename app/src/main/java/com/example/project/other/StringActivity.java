package com.example.project.other;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StringActivity extends AppCompatActivity {

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);
        ButterKnife.bind(this);

        // args
        tv1.setText(getResources().getString(R.string.format_number, 10, 12));

        // plural
        int minute = 1;
        tv2.setText(getResources().getQuantityString(R.plurals.format_quantity, minute));
        minute = 2;
        tv3.setText(getResources().getQuantityString(R.plurals.format_quantity, minute));

        // html
        String text3 = getString(R.string.format_color, "Red");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tv3.setText(Html.fromHtml(text3, Html.FROM_HTML_MODE_LEGACY));
        }

    }
}
