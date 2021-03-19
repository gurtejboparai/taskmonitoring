package com.example.myapplication.presentation;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.business.AccessTask;
import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.TaskPersistence;
import com.example.myapplication.persistence.data.TaskPersistenceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    Task currTask;

    //    private int taskId;
    private int mDate, mMonth, mYear;

    private String taskTitle, taskDescription, taskDate, taskPriority, taskCategory;
    private final String tID = "taskID";

    TextView title, description, date;
    //    ImageButton calender;
    Button status, save, cancel;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch priority;
    ImageButton calender;
    Spinner dropDown;
    ArrayAdapter<CharSequence> adapter;
    private AccessTask accessTask;


//    private AccessTask accessTask = new AccessTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        currTask = (Task) getIntent().getSerializableExtra("TID");
//        taskId = getIntent().getIntExtra(tID,-1);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        taskTitle = currTask.getTaskTitle();
        taskDescription = currTask.getTaskDescription();
        taskDate = currTask.getTaskDate();
        taskPriority=currTask.getPriority();
        taskCategory=currTask.getCategory();



        date = findViewById(R.id.date);
        date.setText(taskDate);
        title = findViewById(R.id.taskTitle);
        title.setText(currTask.getTaskTitle());

        description = findViewById(R.id.taskDescription);
        description.setText(currTask.getTaskDescription());

        priority =findViewById(R.id.highPriority);
        dropDown=findViewById(R.id.dropDown);
        calender=findViewById(R.id.datePicker);
        if(taskPriority.equals("True"))
            priority.setChecked(Boolean.TRUE);
        //status = findViewById(R.id.switchStatus);

        save = findViewById(R.id.saveButton);
        cancel = findViewById(R.id.cancelButton);

        taskTitle = title.getText().toString();
        taskDescription = description.getText().toString();
        adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(adapter);
        int pos=adapter.getPosition(taskCategory);
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
                        date.setText(year+"-"+"0"+(month+1)+"-"+dayOfMonth);

                    }
                },mYear,mMonth,mDate);

                datePickerDialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  accessTask = new AccessTask();
                  Task task=accessTask.getTask(currTask.getCurrTaskId());
                  task.setTaskTitle(title.getText().toString());
                  task.setTaskDescription(description.getText().toString());
                  task.setTaskDate(date.getText().toString());
                  task.setCategory(dropDown.getSelectedItem().toString());
                  if(priority.isChecked())
                      task.setPriority("True");
                  else
                      task.setPriority("False");
                Intent intent = new Intent(getApplicationContext(), ViewTaskActivity.class);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


//        String dbPath;
//
//    public void editTask(Task task) {
//        try(final Connection c= DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "")){
//            final PreparedStatement st = c.prepareStatement("UPDATE TASK SET taskTitle= ?, taskDescription= ?, taskDate= ?, taskStatus= ? WHERE taskId= ?");
//            st.setString(1,task.getTaskTitle());
//            st.setString(2,task.getTaskDescription());
//            st.setString(3,task.getTaskDate());
//            if(task.getStatus()!=null){
//                st.setString(4,task.getStatus());
//            }
//            st.setInt(5,task.getCurrTaskId());
//            st.executeUpdate();
//        }
//        catch (final SQLException e){
//            throw new RuntimeException((e.getMessage()));
//        }
//    }
}
