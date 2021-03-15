package com.example.myapplication.objects;
import android.graphics.Color;

import androidx.annotation.ColorInt;

import java.util.ArrayList;
import java.util.List;

public class ListTag {
    List<Task>taskList;
    @ColorInt int colour;

    ListTag(String tagName){
        taskList = new ArrayList<>();
        if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.FITNESS))){
            colour = Color.BLUE;
        }
        else if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.SCHOOL))){
            colour=Color.RED;
        }
        else if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.WORK))){
            colour = Color.YELLOW;
        }
        else if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.APPOINTMENT))){
            colour = Color.MAGENTA;
        }
        else if(tagName.equalsIgnoreCase(String.valueOf(TaskTag.PRODUCTIVITY))){
            colour = Color.CYAN;
        }
        else
            colour = Color.GREEN;
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

    int getColour(){
        return colour;
    }

}
