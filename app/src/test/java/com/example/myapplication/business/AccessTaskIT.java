package com.example.myapplication.business;

import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.TaskPersistence;
import com.example.myapplication.persistence.hsqldb.TaskPersistenceHSQLDB;
import com.example.myapplication.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class AccessTaskIT {
    private AccessTask accessTask;
    List<Task> taskList;

    @Before
    public void setUp() throws IOException {
        File tempDB = TestUtils.copyDB();
        final TaskPersistence taskPersistence= new TaskPersistenceHSQLDB(tempDB.getAbsolutePath().replace(".script", ""));
        this.accessTask=new AccessTask(taskPersistence);
        taskList=accessTask.getAllTasks();
    }
    @Test
    public void testInsertTask(){
        final Task tasktoAdd = new Task(10, "New task", "Hello Im new","2021-04-04","OTHER","on going","False");
        accessTask.addTask(tasktoAdd);
        Task checkTask = accessTask.getTask(10);
        assertEquals(checkTask.getCurrTaskId(),tasktoAdd.getCurrTaskId());
    }

    @Test
    public void testDeleteTask(){
        final Task tasktoAdd = new Task(10, "New task", "Hello Im new","2021-04-04","OTHER","on going","False");
        accessTask.addTask(tasktoAdd);
        final Task taskToDelete = accessTask.getTask(10);
        Task deleteTask=accessTask.deleteTask(taskToDelete);
        assertEquals(taskToDelete.getCurrTaskId(),deleteTask.getCurrTaskId());
    }

    @Test
    public void testEditTask(){
        final Task tasktoAdd = new Task(10, "New task", "Hello Im new","2021-04-04","OTHER","on going","False");
        accessTask.addTask(tasktoAdd);
        final Task taskToEdit = new Task(10 , "new title","new description","2021-04-04","OTHER","new status","False");
        accessTask.editTask(taskToEdit);
        Task compare = accessTask.getTask(10);
        assertEquals(taskToEdit.getTaskTitle(),compare.getTaskTitle());
    }

    @Test
    public void testEditDate(){
        final Task tasktoAdd = new Task(10, "New task", "Hello Im new","2021-04-04","OTHER","on going","False");
        accessTask.addTask(tasktoAdd);
        final Task task = accessTask.getTask(10);
        accessTask.setTaskDate(task,"2021-05-06");
        assertNotEquals(task.getTaskDate(),accessTask.getTask(10).getTaskDate());
    }



}
