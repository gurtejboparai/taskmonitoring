package com.example.myapplication.Object;

public class Task_Day {
    private final Day day;
    private final Tasks task;
    private String StartTime;
    private String EndTime;
    public Task_Day (final Tasks task, String startTime, String EndTime) throws Day.typeInException {
        this.task=task;
        this.day = new Day(getaYear(), getaMonth(), getaDay());
        this.StartTime=startTime;
        this.EndTime=EndTime;
    }
    public Task_Day(final Tasks task) throws Day.typeInException {
        this.task=task;
        this.day = new Day(getaYear(),getaMonth(),getaDay());
        this.StartTime="startTime";
        this.EndTime="EndTime";
    }
    public Day getTaskDay(){
        return this.day;
    }
    public Tasks getTaskwithDay(){
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

    public int getaMonth(){
        int month =0;
        String[] list = task.getTaskDate().split("-");
        if(list.length==3 )
            month = Integer.parseInt(list[1].trim());
        return month;
    }
    public int getaYear(){
        int year =0;
        String[] list = task.getTaskDate().split("-");
        if(list.length==3 )
            year = Integer.parseInt(list[0].trim());
        return year;
    }
    public int getaDay(){
        int day=0;
        String[] list = this.task.getTaskDate().split("-");
        if(list.length==3 )
            day = Integer.parseInt(list[2].trim());
        return day;
    }

}
