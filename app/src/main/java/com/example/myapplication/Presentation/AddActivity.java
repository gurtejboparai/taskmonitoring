package com.example.myapplication.Presentation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Business.AccessTask;
import com.example.myapplication.Object.Task;
import com.example.myapplication.R;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    private final String taskID = "taskID";
    private AccessTask accessTask;
    TextView date;
    ImageButton calender;
    private int mDate,mMonth,mYear;
    private String titleTxt,descriptionTxt;
    TextView title,description;
    Button highPriority,save,cancel;
    Task newTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        accessTask = new AccessTask();

        date = findViewById(R.id.date);
        calender = findViewById(R.id.datePicker);
        title = findViewById(R.id.taskTitle);
        description = findViewById(R.id.taskDescription);
        highPriority = findViewById(R.id.highPriority);
        save = findViewById(R.id.saveButton);
        cancel = findViewById(R.id.cancelButton);

        titleTxt = title.getText().toString();
        descriptionTxt = description.getText().toString();

        calender.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar calendar=Calendar.getInstance();
                mDate=calendar.get(Calendar.DATE);
                mMonth=calendar.get(Calendar.MONTH);
                mYear=calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(AddActivity.this,
                        android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+"-"+month+"-"+year);

                    }
                },mYear,mMonth,mDate);

                datePickerDialog.show();
            }
        });
//    save.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            newTask=new Tasks(0,titleTxt,descriptionTxt,mYear+"-"+mMonth+"-"+mDate);
//
//        }
//    });
    }

    public void saveBtnOnClick(View view){
        String title;
        String description;
        String date;

        boolean titleEmpty = this.title.getText().toString().isEmpty();
        boolean descriptionEmpty = this.description.getText().toString().isEmpty();
        boolean dateEmpty = this.date.getText().toString().isEmpty();

        if (titleEmpty || descriptionEmpty || dateEmpty) {
            Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
        }else{

            try{
                title = this.title.getText().toString().trim();
                description = this.description.getText().toString().trim();
                date = this.date.getText().toString().trim();

                Task task = new Task(accessTask.getNewTaskId(), title, description, date);
                accessTask.addTask(newTask);
                Toast.makeText(getApplicationContext(), "Task Added", Toast.LENGTH_LONG).show();

                finish();
                Intent viewTasks = new Intent(getApplicationContext(), TaskActivity.class);
                viewTasks.putExtra(taskID, task.getCurrTaskId());

                startActivity(viewTasks);
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(), "Invalid fields", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void cancelBtnOnClick(View v){
        Intent newTaskIntent = new Intent(AddActivity.this, HomeActivity.class);
        AddActivity.this.startActivity(newTaskIntent);
    }
}