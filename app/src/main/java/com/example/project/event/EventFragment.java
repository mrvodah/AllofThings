package com.example.project.event;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.project.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    private static final String TAG = "EventFragment";

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onStop() {
//        EventBus.getDefault().unregister(this);
//        super.onStop();
//    }
//
//    // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
//    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(MessageEvent event) {
//        Log.d(TAG, "onMessageEvent: EventFragment " + event.message);
//        Toast.makeText(getActivity(), event.message, Toast.LENGTH_SHORT).show();
//    }

    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        EventBus.getDefault().post(new MessageEvent("Hello everyone!"));
    }
}
