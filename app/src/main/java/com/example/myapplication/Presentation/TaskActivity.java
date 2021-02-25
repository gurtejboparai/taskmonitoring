package com.example.myapplication.Presentation;

import android.app.Activity;
import android.os.Bundle;

import com.example.myapplication.Business.Access_task;
import com.example.myapplication.Object.Tasks;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
            tasksArrayAdapter = new ArrayAdapter<Tasks>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, tasksList){
                public View getView(int position, View convertView, ViewGroup parent){
                    View view = super.getView(position,convertView,parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                    text1.setText(tasksList.get(position).getTaskTitle());
                    text2.setText(tasksList.get(position).getTaskDescription());
                    return view;
                }
            };
            final ListView listView = (ListView)findViewById(R.id.listTask);
            listView.setAdapter(tasksArrayAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}