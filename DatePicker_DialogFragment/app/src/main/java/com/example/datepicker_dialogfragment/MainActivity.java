package com.example.datepicker_dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setTime(String time){
        Toast.makeText(this,time, Toast.LENGTH_LONG).show();
    }

    public void buttonSelectTime(View view) {
       android.app.FragmentManager fragmentManager = getFragmentManager();
        PopTime popTime = new PopTime();
        popTime.show(fragmentManager, "Younes");
    }
}