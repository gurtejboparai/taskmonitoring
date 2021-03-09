package com.example.myapplication.Presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Date;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        String days[] = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String months[] = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Date date = new Date();

        TextView currDay = findViewById(R.id.day);
        TextView currDate = findViewById(R.id.date);
        currDay.setText(days[date.getDay()]);
        int year = date.getYear() + 1900;
        currDate.setText("" + date.getDate() + " " + months[date.getMonth()] + " " + year);
    }
        public void addTaskBtnOnClick(View v){
            Intent newTaskIntent = new Intent(TaskActivity.this, AddActivity.class);
            TaskActivity.this.startActivity(newTaskIntent);

    }
}