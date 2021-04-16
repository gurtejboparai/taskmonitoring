package com.example.myapplication.presentation;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.business.AccessTask;
import com.example.myapplication.objects.Task;

import java.util.Calendar;

public class EditActivity extends AppCompatActivity {

    Task currTask;

    private int currTaskId;

    private int mDate, mMonth, mYear;

    private String taskTitle, taskDescription, taskDate, taskPriority, taskCategory, taskTag;

    TextView title, description, date;
    Button status, save, cancel;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch priority;
    ImageButton calender;
    Spinner dropDown;
    ArrayAdapter<CharSequence> adapter;
    private AccessTask accessTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        accessTask = new AccessTask();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityedittask);

        // get the task from DB
        currTaskId = getIntent().getIntExtra("TID", -1);
        currTask = accessTask.getTask(currTaskId);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        taskTitle = currTask.getTaskTitle();
        taskDescription = currTask.getTaskDescription();
        taskDate = currTask.getTaskDate();
        taskPriority = currTask.getPriority();
        taskTag = currTask.getTaskTag().toString();
        currTask.setCategory(taskTag);
        taskCategory = currTask.getCategory();


        date = findViewById(R.id.date);
        date.setText(taskDate);
        title = findViewById(R.id.taskTitle);
        title.setText(currTask.getTaskTitle());

        description = findViewById(R.id.taskDescription);
        description.setText(currTask.getTaskDescription());

        priority = findViewById(R.id.highPriority);
        dropDown = findViewById(R.id.dropDown);
        calender = findViewById(R.id.datePicker);
        if (taskPriority.equals("True"))
            priority.setChecked(Boolean.TRUE);

        save = findViewById(R.id.saveButton);
        cancel = findViewById(R.id.cancelButton);

        taskTitle = title.getText().toString();
        taskDescription = description.getText().toString();
        adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(adapter);
        int pos = adapter.getPosition(taskCategory.toUpperCase());

        dropDown.setSelection(pos);

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
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        date.setText(year + "-" + (month + 1) + "-" + dayOfMonth);

                    }
                }, mYear, mMonth, mDate);

                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Task task = accessTask.getTask(currTask.getCurrTaskId());
                boolean titleEmpty = title.getText().toString().trim().isEmpty();
                boolean descriptionEmpty = description.getText().toString().trim().isEmpty();
                boolean dateEmpty = date.getText().toString().trim().isEmpty();

                if (titleEmpty || descriptionEmpty || dateEmpty) {
                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        task.setTaskTitle(title.getText().toString());
                        task.setTaskDescription(description.getText().toString());
                        task.setTaskDate(date.getText().toString());
                        task.setCategory(dropDown.getSelectedItem().toString());
                        if (priority.isChecked())
                            task.setPriority("True");
                        else
                            task.setPriority("False");

                        accessTask.editTask(task);
                        Intent intent = new Intent(getApplicationContext(), ViewTaskActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Invalid fields", Toast.LENGTH_LONG).show();
                    }
                }

                    }
                });
        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}