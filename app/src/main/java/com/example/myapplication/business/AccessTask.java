package com.example.myapplication.business;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.application.Main;
import com.example.myapplication.application.Service;
import com.example.myapplication.objects.TaskTag;
import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.TaskPersistence;
import com.example.myapplication.persistence.data.TaskPersistenceDB;
import com.example.myapplication.persistence.hsqldb.TaskPersistenceHSQLDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class AccessTask extends AppCompatActivity {

    private List<Task> allTasks;
    private final TaskPersistence taskPersistence;



    public AccessTask(){
        taskPersistence = Service.getTaskPersistence();
        allTasks=new ArrayList<>();

    }
    public AccessTask(TaskPersistence DB){
        taskPersistence = DB;
        allTasks= DB.getAllTasks();
    }


    public Task getTask(int taskId) {
        return taskPersistence.getTask(taskId);
    }

    public Task addTask(final Task newTask){
        return taskPersistence.addTask(newTask);
    }

    public Task deleteTask(Task taskToDel){
        return taskPersistence.deleteTask(taskToDel);
    }

    public void editTask(Task task){
        taskPersistence.editTask(task);
    }

    public void setTaskDate(Task task, String taskDate){
        taskPersistence.setTaskDate(task, taskDate);
    }

    public List<Task> getAllTasks() {
        allTasks = taskPersistence.getAllTasks();
        return allTasks;
    }
    public void setStatus(Task task, String newStatus){
        taskPersistence.setStatus(task,newStatus);
    }
    public boolean checkForSame(Task task, Task task1){
        return taskPersistence.checkForSame(task, task1);
    }

    public final int getNewTaskId(){
        return taskPersistence.getNewTaskId();
    }

    public List<Task> getTasksByTag(TaskTag taskTag) {

        List<Task> taskList = new ArrayList<>();

        for (Task task : allTasks) {
            if (task.getTaskTag() == taskTag) {
                taskList.add(task);
            }
        }
        return taskList;
    }


    public List<Task> sortDateInAsc(List<Task> taskList) {

        Collections.sort(taskList, compareTaskDateInAsc);

        return taskList;
    }

    public List<Task> sortDateInDesc(List<Task> taskList) {

        Collections.sort(taskList, compareTaskDateInDesc);

        return taskList;
    }

    Comparator<Task> compareTaskDateInAsc = new Comparator<Task>() {

        @Override
        public int compare(Task task1, Task task2) {

            String str1 = task1.getTaskDate();
            String str2 = task2.getTaskDate();
            String[] date1 = str1.split("-");
            String[] date2 = str2.split("-");

            if (date1 == null) {
                return -1;
            }
            if (date2 == null) {
                return -1;
            }
            if (date2[0].compareTo(date1[0]) < 0) {
                return -1;
            }
            if ((date2[0].compareTo(date1[0]) == 0) && date2[1].compareTo(date1[1]) < 0) {
                return -1;
            }
            if (((date2[0].compareTo(date1[0]) == 0) && (date2[1].compareTo(date1[1]) == 0)) && date2[2].compareTo(date1[2]) < 0) {
                return -1;
            }
            if (((date2[0].compareTo(date1[0]) == 0) && (date2[1].compareTo(date1[1]) == 0)) && date2[2].compareTo(date1[2]) == 0) {
                return 0;
            }

            return 1;
        }

    };

    Comparator<Task> compareTaskDateInDesc = new Comparator<Task>() {

        @Override
        public int compare(Task task1, Task task2) {

            String str1 = task1.getTaskDate();
            String str2 = task2.getTaskDate();
            String[] date1 = str1.split("-");
            String[] date2 = str2.split("-");

            if (date1 == null) {
                return -1;
            }
            if (date2 == null) {
                return -1;
            }
            if (date1[0].compareTo(date2[0]) < 0) {
                return -1;
            }
            if ((date1[0].compareTo(date2[0]) == 0) && date1[1].compareTo(date2[1]) < 0) {
                return -1;
            }
            if (((date1[0].compareTo(date2[0]) == 0) && (date1[1].compareTo(date2[1]) == 0)) && date1[2].compareTo(date2[2]) < 0) {
                return -1;
            }
            if (((date1[0].compareTo(date2[0]) == 0) && (date1[1].compareTo(date2[1]) == 0)) && date1[2].compareTo(date2[2]) == 0) {
                return 0;
            }

            return 1;
        }

    };


        public List<Task> sortPriorityInAsc(List<Task> taskList) {

            Collections.sort(taskList, compareTaskPriorityInAsc);

            return taskList;
        }

        public List<Task> sortPriorityInDesc(List<Task> taskList) {

            Collections.sort(taskList, compareTaskPriorityInDesc);

            return taskList;
        }

        Comparator<Task> compareTaskPriorityInAsc = new Comparator<Task>() {

            @Override
            public int compare(Task taskOne, Task taskTwo) {

                String pOne = taskOne.getPriority();
                String pTwo = taskTwo.getPriority();

                System.out.println("pOne: "+ pOne);
                System.out.println("pTwo: "+ pTwo);

//                if (pOne == null) {
//                    return -1;
//                }
//                if (pTwo == null) {
//                    return -1;
//                }
                if (pOne.equals(pTwo)) {
                    return 0;
                }
                if (pOne.equals("False") && (pTwo.equals("True"))) {
                    return -1;
                }
                return 1;
            }
        };

        Comparator<Task> compareTaskPriorityInDesc = new Comparator<Task>() {

            @Override
            public int compare(Task taskOne, Task taskTwo) {

                String pOne = taskOne.getPriority();
                String pTwo = taskTwo.getPriority();

                System.out.println("pOne: "+ pOne);
                System.out.println("pTwo: "+ pTwo);

//                if (pOne == null) {
//                    return -1;
//                }
//                if (pTwo == null) {
//                    return -1;
//                }
                if (pOne.equals(pTwo)) {
                    return 0;
                }
                if (pOne.equals("False") && (pTwo.equals("True"))) {
                    return 1;
                }
                return -1;
            }
        };

    }
