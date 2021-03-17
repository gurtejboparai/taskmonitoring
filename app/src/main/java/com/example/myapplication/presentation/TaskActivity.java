package com.example.myapplication.presentation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.business.AccessTask;
import com.example.myapplication.objects.Task;
import com.example.myapplication.R;
import com.example.myapplication.objects.TaskTag;
import com.google.android.material.tabs.TabLayout;

import java.util.Date;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private TabLayout tabView;
    private ViewPager viewPager;
    private AccessTask accessTask;

    private TabFragment tabAllTasks;
    private TabFragment tabFitness;
    private TabFragment tabWork;
    private TabFragment tabSchool;
    private TabFragment tabAppointment;
    private TabFragment tabProductivity;
    private TabFragment tabMislenious;

    private String tagName;
    private String typeResult;
    private String Title,Description,date,priority;
    private Task newTask;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);

        accessTask = new AccessTask();
        extras=getIntent().getExtras();
        if(extras!=null)
        {
        Title=extras.getString("Title");
        Description=extras.getString("Description");
        date=extras.getString("Date");
        priority=extras.getString("Priority");
        newTask=new Task(accessTask.getNewTaskId(),Title,Description,date);
        accessTask.addTask(newTask);
        newTask.setPriority(priority);

        }

        initialTabFragment();
        tabSetUp();


//        String days[] = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//        String months[] = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
//        Date date = new Date();
//        AccessTask accessTask=new AccessTask();
//        List<Task> listOfTasks = accessTask.getAllTasks();
//        String titles[]=new String[listOfTasks.size()];
//        String descriptions[]=new String[listOfTasks.size()];
//        for (int i=0;i<listOfTasks.size();i++)
//        {
//            titles[i]=listOfTasks.get(i).getTaskTitle();
//            descriptions[i]=listOfTasks.get(i).getTaskDescription();
//        }
//        TextView currDay = findViewById(R.id.day);
//        TextView currDate = findViewById(R.id.date);
//        currDay.setText(days[date.getDay()]);
//        int year = date.getYear() + 1900;
//        currDate.setText("" + date.getDate() + " " + months[date.getMonth()] + " " + year);
//
//        RecyclerView recyclerView=findViewById(R.id.taskList);
//        MyAdapter myAdapter=new MyAdapter(this,titles,descriptions);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initialTabFragment() {
        tabAllTasks = new TabFragment(accessTask.getAllTasks(), accessTask);
        tabFitness = new TabFragment(accessTask.getTasksByTag(TaskTag.FITNESS), accessTask);
        tabWork = new TabFragment(accessTask.getTasksByTag(TaskTag.WORK), accessTask);
        tabSchool = new TabFragment(accessTask.getTasksByTag(TaskTag.SCHOOL), accessTask);
        tabAppointment = new TabFragment(accessTask.getTasksByTag(TaskTag.APPOINTMENT), accessTask);
        tabProductivity = new TabFragment(accessTask.getTasksByTag(TaskTag.PRODUCTIVITY), accessTask);
        tabMislenious = new TabFragment(accessTask.getTasksByTag(TaskTag.MISLENIOUS), accessTask);
    }


    private void tabSetUp() {
        tabView = findViewById(R.id.tabview_activity);
        viewPager = findViewById(R.id.viewpager_activity);

        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(tabAllTasks, "All");
        adapter.addFragment(tabFitness, "Fitness");
        adapter.addFragment(tabWork, "Work");
        adapter.addFragment(tabSchool, "School");
        adapter.addFragment(tabAppointment, "Appointment");
        adapter.addFragment(tabProductivity, "Productivity");
        adapter.addFragment(tabMislenious, "Others");


        // adapter setup
        viewPager.setAdapter(adapter);
        tabView.setupWithViewPager(viewPager);
    }

    private void categorizeTags(TaskTag taskCategory) {
        tabAllTasks.categorizeTask(taskCategory);
        tabFitness.categorizeTask(taskCategory);
        tabWork.categorizeTask(taskCategory);
        tabSchool.categorizeTask(taskCategory);
        tabAppointment.categorizeTask(taskCategory);
        tabProductivity.categorizeTask(taskCategory);
        tabMislenious.categorizeTask(taskCategory);
    }

    public void addTaskBtnOnClick(View v){
            Intent newTaskIntent = new Intent(TaskActivity.this, AddActivity.class);
            TaskActivity.this.startActivity(newTaskIntent);
    }

//    public void editBtnOnClick(View v) {
//        Intent taskIntent = new Intent(TaskActivity.this, EditActivity.class);
//        TaskActivity.this.startActivity(taskIntent);
//    }

    public void sortBtnOnClick(View view) {
        int pos = tabView.getSelectedTabPosition();

        tabAllTasks.sort();
        tabFitness.sort();
        tabWork.sort();
        tabSchool.sort();
        tabAppointment.sort();
        tabProductivity.sort();
        tabMislenious.sort();

        tabSetUp();

        viewPager.setCurrentItem(pos);
    }


//    public void sortBtnOnClick(View view)
//    {
//        AlertDialog dialog;
//        AlertDialog.Builder builder;
//        final String[] types = {"All", "Priority From Low To High", "Priority From High To Low", "Date In Ascending","Date In Descending"};
//
//        builder = new AlertDialog.Builder(TaskActivity.this);
//
//        builder.setSingleChoiceItems(types, -1, new DialogInterface.OnClickListener()
//        {
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {
//                typeResult = types[which];
//            }
//        });
//
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
//        {
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {
//                TextView textView = findViewById(R.id.textView_mainActivity_adType);
//
//                if (typeResult == null)
//                {
//                    typeResult = types[0];
//                }
//
//                textView.setText(typeResult);
//
//                if (typeResult.equals(types[0]))
//                {
//                    revertTabs();
//                }
//                else
//                {
//                    AdType taskCategory = AdType.valueOf(typeResult);
//
//                    categorizeTags(adType);
//                }
//
//                int position = tabLayout.getSelectedTabPosition();
//                tabSetUp();
//                viewPager.setCurrentItem(position);
//            }
//        });
//
//        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener()
//        {
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {
//
//            }
//        });
//
//        dialog = builder.create();
//        dialog.show();
//    }


}