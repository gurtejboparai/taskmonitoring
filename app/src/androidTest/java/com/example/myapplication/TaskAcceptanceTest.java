package com.example.myapplication;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;


import com.example.myapplication.business.UILogic.TabPagerAdapter;
import com.example.myapplication.objects.Task;
import com.example.myapplication.presentation.SplashPageActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.actionWithAssertions;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.containsString;


@RunWith(AndroidJUnit4.class)
public class TaskAcceptanceTest {

    @Rule
    public ActivityTestRule<SplashPageActivity> activityTestRule = new ActivityTestRule<>(SplashPageActivity.class);

    @Test
    public void addEditTaskTest() {
        SystemClock.sleep(2500);
        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.taskTitle)).perform(typeText("I1 Due"));
        onView(withId(R.id.datePicker)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2021, 4, 18));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.taskDescription)).perform(typeText("Debugging and testing."));
        pressBack();
        onView(withId(R.id.dropDown)).perform(click());
        onView(withText("SCHOOL")).perform(click());
        onView(withId(R.id.saveButton)).perform(click());
        SystemClock.sleep(1200);

        //edit
        onView(withId(R.id.viewpager_activity));
        onView(allOf(withText("I1 Due"))).perform(click());
        onView(withId(R.id.taskTitle)).perform(clearText());
        onView(withId(R.id.taskTitle)).perform(typeText("335 I3 Due"));
        onView(withId(R.id.datePicker)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2021, 4, 29));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.taskDescription)).perform(clearText());
        onView(withId(R.id.taskDescription)).perform(typeText("Debug the feature and Prepare the Presentation"));
        onView(withId(R.id.highPriority)).perform(click());
        pressBack();
        onView(withId(R.id.dropDown)).perform(click());
        onView(withText("SCHOOL")).perform(click());
        onView(withId(R.id.saveButton)).perform(click());
        SystemClock.sleep(1000);

        //continue adding
        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.taskTitle)).perform(typeText("Call Doc"));
        onView(withId(R.id.datePicker)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2021, 4, 20));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.taskDescription)).perform(typeText("Setup appointment for Kevin"));
        onView(withId(R.id.highPriority)).perform(click());
        pressBack();
        onView(withId(R.id.dropDown)).perform(click());
        onView(withText("APPOINTMENT")).perform(click());
        onView(withId(R.id.saveButton)).perform(click());
        SystemClock.sleep(1200);

        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.taskTitle)).perform(typeText("Workout"));
        onView(withId(R.id.datePicker)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2021, 4, 19));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.taskDescription)).perform(typeText("Do cardio for 30 minutes"));
        pressBack();
        onView(withId(R.id.dropDown)).perform(click());
        onView(withText("FITNESS")).perform(click());
        onView(withId(R.id.saveButton)).perform(click());
        SystemClock.sleep(1200);

        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.taskTitle)).perform(typeText("G.O.T."));
        onView(withId(R.id.datePicker)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2021, 4, 18));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.taskDescription)).perform(typeText("Game Of Thrones - Winter is coming"));
        pressBack();
        onView(withId(R.id.saveButton)).perform(click());
        SystemClock.sleep(1200);

        onView(withId(R.id.tabview_activity));
        onView(allOf(withText("FITNESS"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withText("SCHOOL"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.tabview_activity));
        onView(allOf(withText("APPOINTMENT"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.tabview_activity)).perform(swipeLeft());
        onView(allOf(withText("OTHERS"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);

        onView(withId(R.id.tabview_activity)).perform(swipeRight());
        onView(allOf(withText("ALL"), isDisplayed())).perform(click());

        onView(withId(R.id.viewpager_activity)).check(matches(hasDescendant(withText("335 I3 Due"))));
        onView(withId(R.id.viewpager_activity)).check(matches(hasDescendant(withText("Call Doc"))));
        onView(withId(R.id.viewpager_activity)).check(matches(hasDescendant(withText("Workout"))));
        onView(withId(R.id.viewpager_activity)).check(matches(hasDescendant(withText("G.O.T."))));
    }


    @Test
    public void changeStatusAndSortTest(){
        SystemClock.sleep(2500);

        onView(withId(R.id.viewpager_activity));
        onView(allOf(withText("Workout"), isDisplayed())).perform(swipeRight());
        SystemClock.sleep(1500);
        onView(allOf(withText("Call Doc"), isDisplayed())).perform(swipeRight());
        SystemClock.sleep(1500);
        onView(allOf(withText("Workout"), isDisplayed())).perform(swipeRight());
        SystemClock.sleep(1500);

        onView(withId(R.id.tabview_activity));
        onView(allOf(withText("FITNESS"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.tabview_activity));
        onView(allOf(withText("SCHOOL"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.tabview_activity)).perform(swipeLeft());
        onView(allOf(withText("APPOINTMENT"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.tabview_activity)).perform(swipeLeft());
        onView(allOf(withText("OTHERS"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);

        onView(withId(R.id.tabview_activity)).perform(swipeRight());
        onView(allOf(withText("ALL"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.sortSpinner)).perform(click());
        onView(allOf(withText("Priority ▼"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.sortSpinner)).perform(click());
        onView(allOf(withText("Priority ▲"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.sortSpinner)).perform(click());
        onView(allOf(withText("Date ▲"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.sortSpinner)).perform(click());
        onView(allOf(withText("Date ▼"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.sortSpinner)).perform(click());
        onView(allOf(withText("Default"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
    }


    @Test
    public void deleteTaskTest() {
        SystemClock.sleep(2500);
        onView(withId(R.id.viewpager_activity));
        onView(allOf(withText("G.O.T."),isDisplayed())).perform(swipeLeft());
        SystemClock.sleep(1500);
        onView(allOf(withText("Call Doc"),isDisplayed())).perform(swipeLeft());
        SystemClock.sleep(1500);
        onView(allOf(withText("Workout"),isDisplayed())).perform(swipeLeft());
        SystemClock.sleep(1500);
        onView(allOf(withText("335 I3 Due"),isDisplayed())).perform(swipeLeft());
        SystemClock.sleep(1500);

        onView(withId(R.id.tabview_activity));
        onView(allOf(withText("FITNESS"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.tabview_activity)).perform(swipeLeft());
        onView(allOf(withText("SCHOOL"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.tabview_activity)).perform(swipeLeft());
        onView(allOf(withText("APPOINTMENT"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.tabview_activity)).perform(swipeLeft());
        onView(allOf(withText("OTHERS"), isDisplayed())).perform(click());
        SystemClock.sleep(1000);
    }

}