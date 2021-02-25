package com.example.myapplication.Presentation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddTask extends AppCompatActivity {

    TextView date;
    ImageButton calender;
    private int mDate,mMonth,mYear;
    private String titleTxt,descriptionTxt;
    TextView title,description;
    Button highPriority,save,cancel;
    Tasks newTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        date=findViewById(R.id.date);
        calender=findViewById(R.id.datePicker);
        title=findViewById(R.id.taskTitle);
        description=findViewById(R.id.taskDescription);
        highPriority=findViewById(R.id.highPriority);
        save=findViewById(R.id.saveButton);
        cancel=findViewById(R.id.cancelButton);

        titleTxt=title.getText().toString();
        descriptionTxt=description.getText().toString();

        calender.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar calendar=Calendar.getInstance();
                mDate=calendar.get(Calendar.DATE);
                mMonth=calendar.get(Calendar.MONTH);
                mYear=calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(AddTask.this,
                        android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+"-"+month+"-"+year);

                    }
                },mYear,mMonth,mDate);

                datePickerDialog.show();
            }
        });
    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            newTask=new Tasks(0,titleTxt,descriptionTxt,new Date(mYear,mMonth,mDate));
        }
    });
    }
}