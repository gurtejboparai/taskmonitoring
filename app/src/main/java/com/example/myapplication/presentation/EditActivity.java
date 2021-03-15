package com.example.myapplication.presentation;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.business.AccessTask;
import com.example.myapplication.objects.Task;
import com.example.myapplication.R;

import java.util.Calendar;

public class EditActivity extends AppCompatActivity {

    Task currTask;

    private int taskId;
    private int mDate,mMonth,mYear;

    private String taskTitle, taskDescription,taskDate,taskPriority;
    private final String tID = "taskID";

    EditText title,description,date;
    ImageButton calender;
    Button priority, status, save, cancel;

    private AccessTask accessTask = new AccessTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        taskId = getIntent().getIntExtra(tID,-1);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        currTask = accessTask.getTask(taskId);
        taskTitle = currTask.getTaskTitle();
        taskDescription = currTask.getTaskDescription();
        taskDate = currTask.getTaskDate();


        date = findViewById(R.id.editDate);

        calender = findViewById(R.id.datePicker);
        title = findViewById(R.id.editTitle);
        title.setText(taskTitle);

        description = findViewById(R.id.editDescription);
        description.setText(taskDescription);

        priority = findViewById(R.id.switchPrio);

        status = findViewById(R.id.switchStatus);

        save = findViewById(R.id.saveBtn);
        cancel = findViewById(R.id.cancelBtn);

        taskTitle=title.getText().toString();
        taskDescription=description.getText().toString();

        calender.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)

            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                mDate = calendar.get(Calendar.DATE);
                mMonth = calendar.get(Calendar.MONTH);
                mYear = calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(EditActivity.this,
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
                currTask=new Task(0,taskTitle,taskDescription,mYear+"-"+mMonth+"-"+mDate);

            }
        });
    }

}
