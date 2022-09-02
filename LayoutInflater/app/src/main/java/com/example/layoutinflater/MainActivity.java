package com.example.layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonShow(View view) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.showlayout, null);
        EditText editText = view1.findViewById(R.id.editText1);
        editText.setText("Hello");
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view1);
        toast.setDuration(toast.LENGTH_LONG);
        toast.setGravity(Gravity.END, 0, 0);
        toast.show();
    }
}