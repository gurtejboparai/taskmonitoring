package com.example.myapplication.Business;

import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Data.TaskPersistenceDB;
import com.example.myapplication.Persistence.Task_persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class Access_taskTest {

    //private Access_task accessTaskMock;
    private Task_persistence taskPersistence;
    private TaskPersistenceDB taskDB;
    private Access_task accessTaskDB;


    @Before
    public void setUp(){
        taskDB = new TaskPersistenceDB();
        accessTaskDB = new Access_task(taskDB);

        //taskPersistence = mock(Task_persistence.class);
        //accessTaskMock = new Access_task(taskPersistence);

    }

    @Test
    public void testAddNullTask(){

        System.out.println("\nStarting TestAccessTask: add null task");

        Tasks addTask = accessTaskDB.addTask(null);

        assertNull(addTask);

        System.out.println("Finished TestAccessTask...");

    }

    @Test
    public final void testAddNotNullTask(){

        System.out.println("\nStarting TestAccessTask...");

        int taskId = taskDB.getNumOfTasks();

        String title = "3350 Due";
        String description = "Iteration 1";
        String date = "2021-02-26";

        Tasks newTask = new Tasks(taskId, title, description, date);

        Tasks addTask = accessTaskDB.addTask(newTask);

        assertNotNull(addTask);
        assertEquals(taskId, addTask.getCurrTaskId());
        assertEquals("3350 Due",newTask.getTaskTitle());
        assertEquals("Iteration 1",newTask.getTaskDescription());
        assertEquals("2021-02-26",newTask.getTaskDate());

        System.out.println("Finished AccessTaskTest...");
    }

    @Test
    public void testTaskUpdate()
    {
        System.out.println("\nStarting testTaskUpdate: update task we already have...");

        Tasks taskNeedUpdate = accessTaskDB.getTask(0);

        String oldTitle = taskNeedUpdate.getTaskTitle();
        String oldDescription = taskNeedUpdate.getTaskDescription();
        String oldDate = taskNeedUpdate.getTaskDate();

        String newTitle = "i am a new title";
        String newDescription = "i am a new description";

        Tasks updateTask = new Tasks(taskNeedUpdate.getCurrTaskId(), newTitle, newDescription, oldDate);

        accessTaskDB.editTask(taskNeedUpdate,updateTask);

        assertNotEquals(oldTitle, taskNeedUpdate.getTaskTitle());
        assertEquals(oldDescription, taskNeedUpdate.getTaskDescription());
        assertEquals(newTitle, taskNeedUpdate.getTaskTitle());


        System.out.println("\nFinishing testTaskUpdate...");
    }

    @Test
    public final void testRemoveNull()
    {
        System.out.println("\nStarting testRemoveNull...");

        Tasks removeTask = accessTaskDB.deleteTask(null);

        assertNull(removeTask);

        System.out.println("Finished testRemoveNull...");
    }

    @Test
    public void testRemoveNotNull()
    {
        System.out.println("\nStarting testRemoveNotNull...");

        int taskId = 2;

        Tasks taskNeedDel = accessTaskDB.getTask(taskId);

        Assert.assertNotNull(taskNeedDel);
        assertEquals(taskId, taskNeedDel.getCurrTaskId());

        taskNeedDel = accessTaskDB.deleteTask(taskNeedDel);

        assertEquals(taskId, taskNeedDel.getCurrTaskId());

        Tasks checkTask = accessTaskDB.getTask(2);

        assertNull(checkTask);

        System.out.println("Finished testRemoveNotNull...");
    }

    @Test
    public void testGetAllTasks()
    {
        System.out.println("\nStarting testGetAllAds...");

        List<Tasks> tasks = accessTaskDB.getAllTasks();

        assertNotNull(tasks);

        System.out.println("Finished testGetAllAds...");
    }

}