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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class AccessTaskIT {
    private AccessTask accessTask;
    List<Task> taskList;

    @Before
    public void setUp() throws IOException {
        File tempDB = TestUtils.copyDB();
        final TaskPersistence taskPersistence= new TaskPersistenceHSQLDB(tempDB.getAbsolutePath().replace(".script", ""));
        this.accessTask=new AccessTask((TaskPersistenceHSQLDB) taskPersistence);
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
        final Task taskToDelete = accessTask.getTask(0);
        Task deleteTask=accessTask.deleteTask(taskToDelete);
        assertEquals(taskToDelete.getCurrTaskId(),deleteTask.getCurrTaskId());
    }

    @Test
    public void testEditTask(){
        final Task taskToEdit = new Task(0 , "new title","new description","2021-04-04","OTHER","new status","False");
        accessTask.editTask(taskToEdit);
        Task compare = accessTask.getTask(0);
        assertEquals(taskToEdit.getTaskTitle(),compare.getTaskTitle());
    }


}
