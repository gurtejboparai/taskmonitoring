package com.example.myapplication.objects;
import android.graphics.Color;

import androidx.annotation.ColorInt;

import java.util.ArrayList;
import java.util.List;

public class ListTag {
    List<Task> schoolTasks;
    List<Task> workTasks;
    List<Task> fitnessTasks;
    List<Task> appointmentTasks;
    List<Task> productiveTask;
    List<Task> taskList;//default task
    @ColorInt int colour;
    TaskTag tag;

    ListTag(TaskTag tagName){
        taskList = new ArrayList<>();
        productiveTask = new ArrayList<>();
        appointmentTasks = new ArrayList<>();
        fitnessTasks = new ArrayList<>();
        schoolTasks = new ArrayList<>();
        workTasks= new ArrayList<>();
        if(tagName==TaskTag.FITNESS){
            colour = Color.BLUE;
            this.tag=TaskTag.FITNESS;
        }
        else if(tagName == TaskTag.SCHOOL){
            colour=Color.RED;
            this.tag=TaskTag.SCHOOL;
        }
        else if(tagName == TaskTag.WORK){
            colour = Color.YELLOW;
            this.tag = TaskTag.WORK;
        }
        else if(tagName == TaskTag.APPOINTMENT){
            colour = Color.MAGENTA;
            this.tag = TaskTag.APPOINTMENT;
        }
        else if(tagName == TaskTag.PRODUCTIVITY){
            colour = Color.CYAN;
            this.tag = TaskTag.PRODUCTIVITY;
        }
        else {
            colour = Color.GREEN;
            this.tag = TaskTag.MISLENIOUS;
        }
    }

    void addTask(Task newTask){
        TaskTag newTag = newTask.getTaskTag();
        if(newTag==TaskTag.FITNESS){
            fitnessTasks.add(newTask);
        }
        else if(newTag == TaskTag.SCHOOL){
            schoolTasks.add(newTask);
        }
        else if(newTag == TaskTag.WORK){
            workTasks.add(newTask);
        }
        else if(newTag == TaskTag.APPOINTMENT){
            appointmentTasks.add(newTask);
        }
        else if(newTag == TaskTag.PRODUCTIVITY){
            productiveTask.add(newTask);
        }
        else {
            taskList.add(newTask);
        }
    }

    void removeTask(Task rTask){
        TaskTag newTag = rTask.getTaskTag();
        if(newTag==TaskTag.FITNESS){
            fitnessTasks.remove(rTask);
        }
        else if(newTag == TaskTag.SCHOOL){
            schoolTasks.remove(rTask);
        }
        else if(newTag == TaskTag.WORK){
            workTasks.remove(rTask);
        }
        else if(newTag == TaskTag.APPOINTMENT){
            appointmentTasks.remove(rTask);
        }
        else if(newTag == TaskTag.PRODUCTIVITY){
            productiveTask.remove(rTask);
        }
        else {
            taskList.remove(rTask);
        }
    }

    List<Task> getTaskList(TaskTag aTag){
        if(aTag==TaskTag.FITNESS){
            return fitnessTasks;
        }
        else if(aTag == TaskTag.SCHOOL){
            return schoolTasks;
        }
        else if(aTag == TaskTag.WORK){
            return workTasks;
        }
        else if(aTag == TaskTag.APPOINTMENT){
            return appointmentTasks;
        }
        else if(aTag == TaskTag.PRODUCTIVITY){
            return productiveTask;
        }
        else {
            return taskList;
        }
    }

    int getColour(){
        return colour;
    }

}
