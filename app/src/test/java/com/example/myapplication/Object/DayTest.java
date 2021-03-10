package com.example.myapplication.Object;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayTest {
    public Day testDay,testDay2;

    @Before
    public void setUp() throws Day.typeInException {
        System.out.println("\n\tStart the test for Day class\n\n");

        testDay=new Day(2021,10,12);
        testDay2=new Day(1990,6,30);
    }

    @Test
    public void testGetDay() {
        System.out.println("\nstart: test Day.getDay()\n");


        assertEquals("test Day.getDay() fail, it not return correct day value",testDay.getDay(),12);
        assertEquals("test Day.getDay() fail, it not return correct day value",testDay2.getDay(),30);
        assertNotEquals("test Day.getDay() fail, it not return correct day value",testDay.getDay(),10);
        assertNotEquals("test Day.getDay() fail, it not return correct day value",testDay.getDay(),2021);
        assertNotEquals("test Day.getDay() fail, it not return correct day value",testDay.getDay(),0);

        System.out.println("\nend: test Day.getDay()\n");
    }

    @Test
    public void testGetMonth() {
        System.out.println("\nstart: test Day.getMonth()\n");

        assertEquals("test Day.getMonth() fail, it not return correct month value",testDay.getMonth(),10);
        assertEquals("test Day.getMonth() fail, it not return correct month value",testDay2.getMonth(),6);
        assertNotEquals("test Day.getMonth() fail, it not return correct month value",testDay.getMonth(),12);
        assertNotEquals("test Day.getMonth() fail, it not return correct month value",testDay.getMonth(),2021);
        assertNotEquals("test Day.getMonth() fail, it not return correct month value",testDay.getMonth(),0);

        System.out.println("\nend: test Day.getMonth()\n");
    }

    @Test
    public void testGetYear() {
        System.out.println("\nstart: test Day.getYear()\n");


        assertEquals("test Day.getYear() fail, it not return correct Year value",testDay.getYear(),2021);
        assertEquals("test Day.getYear() fail, it not return correct Year value",testDay2.getYear(),1990);
        assertNotEquals("test Day.getYear() fail, it not return correct Year value",testDay.getYear(),12);
        assertNotEquals("test Day.getYear() fail, it not return correct Year value",testDay.getYear(),10);
        assertNotEquals("test Day.getYear() fail, it not return correct Year value",testDay.getYear(),0);


        System.out.println("\nend: test Day.getYear()\n");

    }

    @Test
    public void testChangeDay() throws Day.typeInException {
        System.out.println("\nstart: test Day.changeDay()\n");

        testDay2.changeDay(30);
        assertEquals("should change day to 30, but not work",testDay2.getDay(),30);



        System.out.println("\nend: test Day.changeDay()\n");
    }

    @Test
    public void testChangeMonth() throws Day.typeInException {
        System.out.println("\nstart: test Day.changeMonth()\n");

            testDay2.changeMonth(3);
            assertEquals("should change month to 3, but not work",testDay2.getMonth(),3);

        System.out.println("\nend: test Day.changeMonth()\n");
    }

    @Test
    public void testChangeYear() throws Day.typeInException {
        System.out.println("\nstart: test Day.changeYear()\n");

            testDay2.changeYear(2014);
            assertEquals("should change year to 2014, but not work",testDay2.getYear(),2014);

        System.out.println("\nend: test Day.changeYear()\n");
    }
    @After
    public void after(){
        System.out.println("\n\n\t end the day test");
    }
}
