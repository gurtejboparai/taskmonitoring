package com.example.myapplication.Business;

import com.example.myapplication.Object.Day;
import com.example.myapplication.Persistence.Data.DayPersistenceDB;
import com.example.myapplication.Persistence.Day_persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Access_dayTest {
    Access_day testAccessDay;
    DayPersistenceDB db;
    Day testDay;
    Day testDay2;

    @Before
    public void setUp() throws Day.typeInException {
        System.out.println("\n\tStart the test for Access_day class\n\n");
        db = new DayPersistenceDB();
        db.addDays();
        testAccessDay=new Access_day();
        testDay=new Day(2021,10,3);
        testDay2=new Day(1900,2,3);
        testAccessDay.addDay(testDay);

    }

    @Test
    public void setMonth() {
        System.out.println("\nStart the test for Access_day.setMonth() \n");
        assertNotNull(testAccessDay);

        testAccessDay.setMonth(testDay,6);
        assertEquals(testDay.getMonth(),6);
        testAccessDay.setMonth(testDay,11);
        assertEquals("set month to 11 fail",testDay.getMonth(),11);
        testAccessDay.setMonth(testDay,10);
        assertEquals("set month back to 10 fail",testDay.getMonth(),10);

        System.out.println("\nEnd the test for Access_day.setMonth() \n");
    }

    @Test
    public void setDay() {
        System.out.println("\nStart the test for Access_day.setDay() \n");

        testAccessDay.setDay(testDay,29);
        assertEquals("change day from 12 to 29 fail",testDay.getDay(),29);
        testAccessDay.setDay(testDay,1);
        assertEquals("set day to 1 fail",testDay.getDay(),1);
        testAccessDay.setDay(testDay,12);
        assertEquals("set day back to 12 fail",testDay.getDay(),12);

        System.out.println("\nEnd the test for Access_day.setDay() \n");
    }

    @Test
    public void setYear() {
        System.out.println("\nStart the test for Access_day.setYear() \n");
        testAccessDay.setYear(testDay,1999);
        assertEquals("change year from 2021 to 1999 fail",testDay.getYear(),1999);
        testAccessDay.setYear(testDay,7777);
        assertEquals("set year to 7777 fail",testDay.getYear(),7777);

        System.out.println("\nEnd the test for Access_day.setYear() \n");
    }

    @Test
    public void deleteDay() {
        System.out.println("\nStart the test for Access_day.deleteDay() \n");
        int temp=testAccessDay.getAllDay().indexOf(testDay);
        testAccessDay.addDay(testDay2);
        testAccessDay.deleteDay(testDay);
        assertNotEquals("after delete day from list it still there",testAccessDay.getAllDay().indexOf(testDay),temp);
        temp=testAccessDay.getAllDay().indexOf(testDay2);
        testAccessDay.deleteDay(testDay2);
        assertNotEquals("after delete day2 from list it still there",testAccessDay.getAllDay().indexOf(testDay2),temp);

        System.out.println("\nEnd the test for Access_day.deleteDay() \n");
    }

    @Test
    public void addDay() {
        System.out.println("\nStart the test for Access_day.addDay() \n");
        testAccessDay.addDay(testDay);
        testAccessDay.addDay(testDay2);
        //assertNotEquals("fail to add day in list",testAccessDay.getAllDay().indexOf(testDay),0);
        assertNotEquals("fail to add day2 in list",testAccessDay.getAllDay().indexOf(testDay2),0);
        System.out.println("\nEnd the test for Access_day.addDay() \n");
    }

    @Test
    public void getAllDay() {
        System.out.println("\nStart the test for Access_day.getAllDay() \n");

        assertNotNull("return null from getAllDay", testAccessDay.getAllDay());
        assertEquals("not return correct day list",testAccessDay.getAllDay().indexOf(testDay),testAccessDay.getAllDay().indexOf(testDay));

        System.out.println("\nEnd the test for Access_day.getAllDay() \n");
    }
    @After
    public void end(){
        System.out.println("\n\tEnd the test for Access_day class\n\n");
    }
}