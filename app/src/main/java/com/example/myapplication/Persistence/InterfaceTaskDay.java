package com.example.myapplication.Persistence;

import com.example.myapplication.Object.TaskDay;

import java.util.List;

public interface InterfaceTaskDay {
    void setDeadline(TaskDay td, String start, String end);
    List<TaskDay> getTaskDay(int TaskID);
    List<TaskDay>getAllTD();
}
