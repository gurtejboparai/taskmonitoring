package com.example.myapplication.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.business.AccessTask;
import com.example.myapplication.business.UILogic.TabFragment;
import com.example.myapplication.business.UILogic.TabPagerAdapter;
import com.example.myapplication.objects.Task;
import com.example.myapplication.objects.TaskTag;
import com.google.android.material.tabs.TabLayout;

public class ViewTaskActivity extends AppCompatActivity {

    private TabLayout tabView;
    private ViewPager viewPager;
    private AccessTask accessTask;

    private TabFragment tabAllTasks;
    private TabFragment tabFitness;
    private TabFragment tabWork;
    private TabFragment tabSchool;
    private TabFragment tabAppointment;
    private TabFragment tabProductivity;
    private TabFragment tabOthers;

    private String Title, Description, date, priority,taskTag;
    private Task newTask;
    Bundle extras;
    Spinner dropDown;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);

        accessTask = new AccessTask();
        extras = getIntent().getExtras();
        dropDown=findViewById(R.id.sortSpinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.sortBy, R.layout.spinner_style);
        adapter.setDropDownViewResource(R.layout.spinner_popup_style);
        dropDown.setAdapter(adapter);

        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if(position==0){
                    sortDefault(selectedItemView);
                }
                if(position==1){
                    sortPrioDD(selectedItemView);
                }
                if(position==2){
                    sortPrioAA(selectedItemView);
                }
                if(position==3){
                    sortDateDD(selectedItemView);
                }
                if(position==4){
                    sortDateAA(selectedItemView);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        if (extras != null) {
            Title = extras.getString("Title");
            Description = extras.getString("Description");
            date = extras.getString("Date");
            priority = extras.getString("Priority");
            taskTag=extras.getString("Tag");
            newTask = new Task(accessTask.getNewTaskId(), Title, Description, date);
            newTask.setPriority(priority);
            newTask.setCategory(taskTag);
            accessTask.addTask(newTask);
            Notifications startChannel = new Notifications(accessTask);
        }

        initialTabFragment();
        tabSetUp();

    }


    private void initialTabFragment() {
        tabAllTasks = new TabFragment(accessTask.getAllTasks(), accessTask);
        tabFitness = new TabFragment(accessTask.getTasksByTag(TaskTag.FITNESS), accessTask);
        tabWork = new TabFragment(accessTask.getTasksByTag(TaskTag.WORK), accessTask);
        tabSchool = new TabFragment(accessTask.getTasksByTag(TaskTag.SCHOOL), accessTask);
        tabAppointment = new TabFragment(accessTask.getTasksByTag(TaskTag.APPOINTMENT), accessTask);
        tabProductivity = new TabFragment(accessTask.getTasksByTag(TaskTag.PRODUCTIVITY), accessTask);
        tabOthers = new TabFragment(accessTask.getTasksByTag(TaskTag.OTHERS), accessTask);
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
        adapter.addFragment(tabOthers, "Others");


        // adapter setup
        viewPager.setAdapter(adapter);
        tabView.setupWithViewPager(viewPager);
    }

//
//    private void categorizeTags(TaskTag taskCategory) {
//        tabAllTasks.categorizeTask(taskCategory);
//        tabFitness.categorizeTask(taskCategory);
//        tabWork.categorizeTask(taskCategory);
//        tabSchool.categorizeTask(taskCategory);
//        tabAppointment.categorizeTask(taskCategory);
//        tabProductivity.categorizeTask(taskCategory);
//        tabOthers.categorizeTask(taskCategory);
//    }

    public void addTaskBtnOnClick(View v) {
        Intent newTaskIntent = new Intent(ViewTaskActivity.this, AddActivity.class);
        ViewTaskActivity.this.startActivity(newTaskIntent);
    }

    public void sortDefault(View view){
        int pos = tabView.getSelectedTabPosition();
        tabAllTasks.sortDefault();
        tabFitness.sortDefault();
        tabWork.sortDefault();
        tabSchool.sortDefault();
        tabAppointment.sortDefault();
        tabProductivity.sortDefault();
        tabOthers.sortDefault();
        tabSetUp();
        viewPager.setCurrentItem(pos);
    }

    public void sortPrioAA(View view) {
        int pos = tabView.getSelectedTabPosition();
        tabAllTasks.sortPrioA();
        tabFitness.sortPrioA();
        tabWork.sortPrioA();
        tabSchool.sortPrioA();
        tabAppointment.sortPrioA();
        tabProductivity.sortPrioA();
        tabOthers.sortPrioA();
        tabSetUp();
        viewPager.setCurrentItem(pos);
    }

    public void sortPrioDD(View view) {
        int pos = tabView.getSelectedTabPosition();
        tabAllTasks.sortPrioD();
        tabFitness.sortPrioD();
        tabWork.sortPrioD();
        tabSchool.sortPrioD();
        tabAppointment.sortPrioD();
        tabProductivity.sortPrioD();
        tabOthers.sortPrioD();
        tabSetUp();
        viewPager.setCurrentItem(pos);
    }

    public void sortDateAA(View view) {
        int pos = tabView.getSelectedTabPosition();

        tabAllTasks.sortDateA();
        tabFitness.sortDateA();
        tabWork.sortDateA();
        tabSchool.sortDateA();
        tabAppointment.sortDateA();
        tabProductivity.sortDateA();
        tabOthers.sortDateA();
        tabSetUp();
        viewPager.setCurrentItem(pos);
    }

    public void sortDateDD(View view){
        int pos = tabView.getSelectedTabPosition();
        tabAllTasks.sortDateD();
        tabFitness.sortDateD();
        tabWork.sortDateD();
        tabSchool.sortDateD();
        tabAppointment.sortDateD();
        tabProductivity.sortDateD();
        tabOthers.sortDateD();
        tabSetUp();
        viewPager.setCurrentItem(pos);
    }




}