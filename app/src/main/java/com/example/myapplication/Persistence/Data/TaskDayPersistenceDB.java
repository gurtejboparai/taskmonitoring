package com.example.myapplication.Persistence.Data;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Object.Task_Day;
import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Interface_TD;

import java.util.ArrayList;
import java.util.List;

public class TaskDayPersistenceDB implements Interface_TD {
    List<Task_Day> taskDayList;
    int numOfTasks=0;
    public TaskDayPersistenceDB(){
        taskDayList= new ArrayList<>();
    }

    public void addTaskDay() throws Day.typeInException{
        taskDayList.add(new Task_Day(new Tasks(numOfTasks +1, "Call the doctor","setup appointment for Kevin","2021-03-02")));
        taskDayList.add(new Task_Day(new Tasks(numOfTasks +1,"Workout","Do cardio for 30 minutes","2021-03-04"), "5:00","7:00"));
        taskDayList.add(new Task_Day(new Tasks(numOfTasks +1,"COMP3350 due","Iteration-1 due on Friday","2021-03-03"),"10:00","4:00"));
        taskDayList.add(new Task_Day(new Tasks(numOfTasks +1,"Meal Prep","Prepare the meals for next 3 days and store","2021-03-03"),"17:00","19:00"));
        taskDayList.add(new Task_Day(new Tasks(numOfTasks +1,"COMP3340 lab","Lab-3 is due tomorrow", "2021-02-28")));

    }

    public void addTaskDayP(Task_Day newItem){
        taskDayList.add(newItem);
    }
    @Override
    public void setDeadline(Task_Day td, String start, String end) {
        int index = taskDayList.indexOf(td);
        if(index>=0) {
            td.setDeadline(start, end);
            taskDayList.set(index,td);
        }
    }

    @Override
    public Task_Day getTaskDay(Task_Day td) {
        int index = taskDayList.indexOf(td);
        if(index>=0) {
           return taskDayList.get(index);
        }
        else
            return null;
    }


    @Override
    public List<Task_Day> getAllTD() {
        return taskDayList;
    }
}
