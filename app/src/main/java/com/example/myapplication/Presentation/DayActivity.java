package com.example.myapplication.Presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        String dateString=new SimpleDateFormat("MM dd, yyyy", Locale.getDefault()).format(new Date());
        TextView date =findViewById(R.id.editDate);
        date.setText(dateString);
    }
    public void buttonAddTaskOnClick(){
        Intent newTaskIntent = new Intent(DayActivity.this, AddActivity.class);
        DayActivity.this.startActivity(newTaskIntent);
    }


}