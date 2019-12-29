package com.example.project.calendarevent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;
import com.kizitonwose.calendarview.CalendarView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalendarEventActivity extends AppCompatActivity {
    @BindView(R.id.exThreeCalendar)
    CalendarView calendarView;

//    @BindView(R.id.calendarView)
//    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_event);
        ButterKnife.bind(this);

//        List<EventDay> events = new ArrayList<>();
//
//        Calendar calendar = Calendar.getInstance();
//        events.add(new EventDay(calendar, R.drawable.ic_brightness_1_black_24dp));
////        events.add(new EventDay(calendar, CalendarUtils.getDrawableText(this ,"simple", Typeface.DEFAULT, R.color.colorAccent, 12)));
//        //or
////        events.add(new EventDay(calendar, new Drawable()));
//        //or if you want to specify event label color
////        events.add(new EventDay(calendar, R.drawable.sample_icon, Color.parseColor("#228B22")));
//
//        calendarView.setEvents(events);



    }
}
