package com.example.myapplication.Business;
import android.content.Context;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Object.Task_Day;
import com.example.myapplication.Object.Tasks;
import com.example.myapplication.Persistence.Data.TaskDayPersistenceDB;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AccessTDTest {

    private TaskDayPersistenceDB taskDayPersistenceDB;
    private Access_TD accessTd;
    int numOfTasks =0;
    @Before
    public void setUp(){
        taskDayPersistenceDB = new TaskDayPersistenceDB();
        accessTd = new Access_TD(taskDayPersistenceDB);
    }
    @Test
    public void testAddTaskDayNull() throws Day.typeInException {
        Task_Day task = new Task_Day(null);
        assertNull(task);
    }
    @Test
    public void testSetDeadline() throws Day.typeInException {
        Task_Day taskDay =  new Task_Day(new Tasks(numOfTasks +1,"COMP3340 lab","Lab-3 is due tomorrow", "2021-02-28"));
        String startTime ="13:00";
        String endTime ="15:00";
        taskDay.setDeadline("13:00","15:00");
        assertEquals(startTime,taskDay.getStartTime());
        assertEquals(endTime,taskDay.getEndTime());
    }
    @Test
    public void testList(){
        List<Task_Day>TDList = taskDayPersistenceDB.getAllTD();
        assertNull(TDList);
    }

}
