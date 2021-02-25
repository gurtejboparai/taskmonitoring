package com.example.myapplication.Object;

public class Task_Day {
    private final Day day;
    private final Tasks task;
    private String StartTime;
    private String EndTime;
    public Task_Day(final Tasks task, String startTime, String EndTime){
        this.task=task;
        this.day = new Day(getaYear(),getaMonth(),getaDay());
        this.StartTime=startTime;
        this.EndTime=EndTime;
    }
    public Task_Day(final Tasks task){
        this.task=task;
        this.day = new Day(getaYear(),getaMonth(),getaDay());
        this.StartTime="startTime";
        this.EndTime="EndTime";
    }
    public Day getDay(){
        return this.day;
    }
    public Tasks getTask(){
        return this.task;
    }
    public String getStartTime(){
        return this.StartTime;
    }
    public String getEndTime(){
        return this.EndTime;
    }
    public void setDeadline(String start, String end){
        this.StartTime=start;
        this.EndTime=end;
    }

    private int getaMonth(){
        int month =-1;
        String list[] = task.getTaskDate().split("-");
        if(list.length==3 )
            month = Integer.parseInt(list[1].trim());
        return month;
    }
    private int getaYear(){
        int year =-1;
        String list[] = task.getTaskDate().split("-");
        if(list.length==3 )
            year = Integer.parseInt(list[0].trim());
        return year;
    }
    private int getaDay(){
        int day=-1;
        String list[] = task.getTaskDate().split("-");
        if(list.length==3 )
            day = Integer.parseInt(list[0].trim());
        return day;
    }


}
