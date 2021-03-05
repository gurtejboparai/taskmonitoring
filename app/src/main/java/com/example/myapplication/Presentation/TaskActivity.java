package com.example.myapplication.Presentation;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Business.AccessTask;
import com.example.myapplication.Object.Task;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private List<Task> tasksList;
    private ArrayAdapter<Task> tasksArrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        AccessTask accessTask = new AccessTask();
        try{
            tasksList=new ArrayList<>();
            tasksList.addAll(accessTask.getAllTasks());
            tasksArrayAdapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, tasksList){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    View view = super.getView(position,convertView,parent);
                    TextView title = (TextView) view.findViewById(android.R.id.text1);
                    TextView day = (TextView) view.findViewById(android.R.id.text2);
                    TextView description = (TextView)view.findViewById(R.id.descriptionTask);

                    title.setText(tasksList.get(position).getTaskTitle());
                    day.setText(tasksList.get(position).getTaskDate());
                    description.setText((tasksList.get(position).getTaskDescription()));
                    return view;
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
    public void editButtonOnClick(View v){
        Intent newTaskIntent = new Intent(TaskActivity.this, EditActivity.class);
        TaskActivity.this.startActivity(newTaskIntent);
    }
    public void addButtonOnclick(View v){
        Intent newTaskIntent = new Intent(TaskActivity.this, AddActivity.class);
        TaskActivity.this.startActivity(newTaskIntent);
    }

}