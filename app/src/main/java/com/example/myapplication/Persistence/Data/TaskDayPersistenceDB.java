package com.example.myapplication.Persistence.Data;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Object.TaskDay;
import com.example.myapplication.Object.Task;
import com.example.myapplication.Persistence.InterfaceTaskDay;

import java.util.ArrayList;
import java.util.List;

public class TaskDayPersistenceDB implements InterfaceTaskDay {
    List<TaskDay> taskDayList;
    int numOfTasks=0;
    public TaskDayPersistenceDB(){
        taskDayList= new ArrayList<>();
    }

    public void addTaskDay() throws Day.typeInException{
        taskDayList.add(new TaskDay(new Task(numOfTasks +1, "Call the doctor","setup appointment for Kevin","2021-03-02")));
        taskDayList.add(new TaskDay(new Task(numOfTasks +1,"Workout","Do cardio for 30 minutes","2021-03-04"), "5:00","7:00"));
        taskDayList.add(new TaskDay(new Task(numOfTasks +1,"COMP3350 due","Iteration-1 due on Friday","2021-03-03"),"10:00","4:00"));
        taskDayList.add(new TaskDay(new Task(numOfTasks +1,"Meal Prep","Prepare the meals for next 3 days and store","2021-03-03"),"17:00","19:00"));
        taskDayList.add(new TaskDay(new Task(numOfTasks +1,"COMP3340 lab","Lab-3 is due tomorrow", "2021-02-28")));

    }

    public void addTaskDayP(TaskDay newItem){
        taskDayList.add(newItem);
    }
    @Override
    public void setDeadline(TaskDay td, String start, String end) {
        int index = taskDayList.indexOf(td);
        if(index>=0) {
            td.setDeadline(start, end);
            taskDayList.set(index,td);
        }
    }

    @Override
    public List<TaskDay> getTaskDay(int n) {
        List<TaskDay>listofTarget = new ArrayList<>();
        for(TaskDay task:taskDayList){
            if(task.getTaskwithDay().getCurrTaskId()==n){
                listofTarget.add(task);
            }
        }
        return listofTarget;
    }


    @Override
    public List<TaskDay> getAllTD() {
        return taskDayList;
    }
}
