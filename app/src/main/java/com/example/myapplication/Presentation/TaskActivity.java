package com.example.myapplication.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Business.Access_task;
import com.example.myapplication.Object.Tasks;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private Access_task accessTask;
    private List<Tasks> tasksList;
    private ArrayAdapter<Tasks> tasksArrayAdapter;
    int selectPos =-1;

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
                        TextView title = (TextView) view.findViewById(R.id.nameTask);
                        TextView day = (TextView) view.findViewById(R.id.descriptionTask);

                        title.setText(tasksList.get(position).getTaskTitle());
                        day.setText(tasksList.get(position).getTaskDate());
                        status.setText(tasksList.get(position).getStatus());
                    return view;
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
    public void editButtonOnClick(View v){
        Intent newTaskIntent = new Intent(TaskActivity.this, EditActivity.class);
        TaskActivity.this.startActivity(newTaskIntent);
    }
    public void addButtonOnclick(View v){
        Intent newTaskIntent = new Intent(TaskActivity.this, AddTask.class);
        TaskActivity.this.startActivity(newTaskIntent);
    }

}