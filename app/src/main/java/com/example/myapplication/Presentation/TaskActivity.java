package com.example.myapplication.Presentation;

import android.os.Bundle;

import com.example.myapplication.Business.Access_task;
import com.example.myapplication.Object.Tasks;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private Access_task accessTask;
    private List<Tasks> tasksList;
    private ArrayAdapter<Tasks> tasksArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        accessTask= new Access_task();
        try{
            tasksList=new ArrayList<>();
            tasksList.addAll(accessTask.getAllTasks());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}