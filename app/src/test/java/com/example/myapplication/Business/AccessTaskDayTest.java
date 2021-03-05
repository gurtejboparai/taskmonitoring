package com.example.myapplication.Business;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Object.TaskDay;
import com.example.myapplication.Object.Task;
import com.example.myapplication.Persistence.Data.TaskDayPersistenceDB;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AccessTaskDayTest {

    private TaskDayPersistenceDB taskDayPersistenceDB;
    private AccessTaskDay accessTd;
    int numOfTasks =0;
    @Before
    public void setUp() throws Day.typeInException {
        taskDayPersistenceDB = new TaskDayPersistenceDB();
        taskDayPersistenceDB.addTaskDay();
        accessTd = new AccessTaskDay(taskDayPersistenceDB);
    }
    @Test
    public void testSetDeadline() throws Day.typeInException {
        TaskDay taskDay =  new TaskDay(new Task(numOfTasks +1,"COMP3340 lab","Lab-3 is due tomorrow", "2021-02-28"));
        String startTime ="13:00";
        String endTime ="15:00";
        taskDay.setDeadline("13:00","15:00");
        assertEquals(startTime,taskDay.getStartTime());
        assertEquals(endTime,taskDay.getEndTime());
    }

}
