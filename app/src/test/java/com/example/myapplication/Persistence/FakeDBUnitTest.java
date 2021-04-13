package com.example.myapplication.Persistence;

import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.TaskPersistence;
import com.example.myapplication.persistence.data.TaskPersistenceDB;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class FakeDBUnitTest {
    @Test
    public void InitializeDB(){
        TaskPersistenceDB db = new TaskPersistenceDB();
        assertNotNull("The database should not be empty",db.getAllTasks());
    }

    @Test
    public void TestGetTask(){
        //check for exist task in database
        TaskPersistence db = new TaskPersistenceDB();
        Task newTask = db.getTask(0);
        assertNotNull("Task is not null",newTask);

        //check for not exist task in database
        Task aTask  = db.getTask(10);
        assertNull("Task should be Null", aTask);
    }

    @Test
    public void TestAddTask(){
        TaskPersistence db = new TaskPersistenceDB();
        Task newTask = new Task(10,"Talk to the manager","Inform my new availability to the manager ","2021-03-03","Appointment","False");
        db.addTask(newTask);
        Task checkTask = db.getTask(10);
        assertNotNull("Task should not be Null",checkTask);
    }

    @Test
    public void TestEditTask(){
        TaskPersistence db = new TaskPersistenceDB();
        Task oldTask = db.getTask(0);
        Task newTask = new Task(0, "new Title", "new Description", "2021-03-02");
        db.editTask(newTask);
        newTask = db.getTask(0);
        assertNotEquals(oldTask.getTaskTitle(),newTask.getTaskTitle());
        assertNotEquals(oldTask.getTaskDescription(),newTask.getTaskDescription());
    }

    @Test
    public void TestDeleteTask(){
        TaskPersistence db = new TaskPersistenceDB();
        Task dTask = db.getTask(1);
        Task cTask = db.deleteTask(dTask);
        assertEquals(dTask.getCurrTaskId(),cTask.getCurrTaskId());
        assertEquals(dTask.getTaskTitle(),cTask.getTaskTitle());
    }

    @Test
    public void TestSetTaskDate(){
        TaskPersistence db = new TaskPersistenceDB();
        Task dTask = db.getTask(1);
        String date = dTask.getTaskDate();
        db.setTaskDate(dTask, "2021-05-04");
        Task cTask = db.getTask(1);
        assertNotEquals(cTask.getTaskDate(),date);
    }

    @Test
    public void TestGetAllTask(){
        TaskPersistence db = new TaskPersistenceDB();
        List aList = db.getAllTasks();
        assertNotNull(aList);
    }

}
