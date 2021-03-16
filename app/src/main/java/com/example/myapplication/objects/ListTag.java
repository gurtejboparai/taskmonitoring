package com.example.myapplication.objects;
import android.graphics.Color;

import androidx.annotation.ColorInt;

import java.util.ArrayList;
import java.util.List;

public class ListTag {
    List<Task>taskList;
    @ColorInt int colour;
    TaskTag tag;

    ListTag(String tagName){
        taskList = new ArrayList<>();
        if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.FITNESS))){
            colour = Color.BLUE;
            this.tag=TaskTag.FITNESS;
        }
        else if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.SCHOOL))){
            colour=Color.RED;
            this.tag=TaskTag.SCHOOL;
        }
        else if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.WORK))){
            colour = Color.YELLOW;
            this.tag = TaskTag.WORK;
        }
        else if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.APPOINTMENT))){
            colour = Color.MAGENTA;
            this.tag = TaskTag.APPOINTMENT;
        }
        else if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.PRODUCTIVITY))){
            colour = Color.CYAN;
            this.tag = TaskTag.PRODUCTIVITY;
        }
        else {
            colour = Color.GREEN;
            this.tag = TaskTag.MISLENIOUS;
        }
    }

    void addTask(Task newTask){
        taskList.add(newTask);
    }

    void removeTask(Task rTask){
        taskList.remove(rTask);
    }

    List<Task> getTaskList(){
        return taskList;
    }

    TaskTag getTagList(){
        return tag;
    }


    int getColour(){
        return colour;
    }

}
