package com.example.myapplication.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.business.AccessTask;
import com.example.myapplication.objects.Task;
import com.example.myapplication.R;

import java.util.Date;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        String days[] = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String months[] = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Date date = new Date();
        AccessTask accessTask=new AccessTask();
        List<Task> listOfTasks = accessTask.getAllTasks();
        String titles[]=new String[listOfTasks.size()];
        String descriptions[]=new String[listOfTasks.size()];
        for (int i=0;i<listOfTasks.size();i++)
        {
            titles[i]=listOfTasks.get(i).getTaskTitle();
            descriptions[i]=listOfTasks.get(i).getTaskDescription();
        }
        TextView currDay = findViewById(R.id.day);
        TextView currDate = findViewById(R.id.date);
        currDay.setText(days[date.getDay()]);
        int year = date.getYear() + 1900;
        currDate.setText("" + date.getDate() + " " + months[date.getMonth()] + " " + year);

        RecyclerView recyclerView=findViewById(R.id.taskList);
        MyAdapter myAdapter=new MyAdapter(this,titles,descriptions);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
        public void addTaskBtnOnClick(View v){
            Intent newTaskIntent = new Intent(TaskActivity.this, AddActivity.class);
            TaskActivity.this.startActivity(newTaskIntent);

    }
}