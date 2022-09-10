package com.example.datepicker_dialogfragment;

import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

public class PopTime extends DialogFragment implements View.OnClickListener {
    View view;
    TimePicker timePicker;
    Button buttonDone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    view = inflater.inflate(R.layout.popdate,container, false);
        timePicker = view.findViewById(R.id.timePicker);
        buttonDone = view.findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(this);
    return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        this.dismiss();
        String timeOn = timePicker.getHour() + ":" + timePicker.getMinute();
        MainActivity mainActivity;
        mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.setTime(timeOn);
    }

}
