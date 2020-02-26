package com.example.project.bottomsheet;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.project.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

import butterknife.internal.Utils;

import static android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE;

/**
 * Created at: 08:00pm 19/12/19
 * Created by: Hung
 * Description: common fragment input value
 **/
public class InputBottomSheetFragment extends CustomBottomSheetDialogFragment {

    private static final String TAG = "InputBottomSheetFragmen";
    EditText edtInput;
    TextView tvTitle;
    Button btnConform, btnCancel;

    CardView cardView;

    @SuppressLint("WrongConstant")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.input_bottom_sheet_fragment, container, false);
        edtInput = v.findViewById(R.id.code_value);
        btnConform = v.findViewById(R.id.btn_conform);
        btnCancel = v.findViewById(R.id.btn_cancel);
        tvTitle = v.findViewById(R.id.title);

        cardView = v.findViewById(R.id.card_view);

        return v;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {  // expand height
//                BottomSheetDialog dialog = (BottomSheetDialog) getDialog();
//                FrameLayout bottomSheet = (FrameLayout)
//                        dialog.findViewById(R.id.design_bottom_sheet);
//                BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
//                behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//                    @Override
//                    public void onStateChanged(@NonNull View view, int i) {
//
//                    }
//
//                    @Override
//                    public void onSlide(@NonNull View view, float v) {
//                        if (isViewCreated) {
//                            if (v == 0f) {
//                                dismiss();
//                            }
//                        }
//                    }
//                });
//                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                behavior.setPeekHeight(0);
//            }
//        });
//        isViewCreated = true;
//    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = new BottomSheetDialog(getContext(), R.style.BottomSheetDialog); // style to transparent
//        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
//            @Override
//            public void onShow(DialogInterface dialog) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        BottomSheetDialog d = (BottomSheetDialog) dialog;
//                        FrameLayout bottomSheet = d.findViewById(R.id.design_bottom_sheet);
//                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
//                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                    }
//                },0);
//            }
//        });
        return dialog;
    }

}
