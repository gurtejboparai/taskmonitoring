What technical debt has been cleaned up
========================================
- Tech debt has been cleaned up is
1. [Empty task can be accept](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/63)
2. [Task can be create in the past](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/64)
3. [app become unreposive when change orentation](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/61)
4. [Data is not available for editing when orientation is horizontal](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/62)

For the first one, we put restriction so that empty task cannot be create during while user using the app. Moreover, we set the day properly so that user can only create task in the current day and future day. Then our group work on reposive for the app and creating landscap mode so that app can work on any orientation

What technical debt did you leave?
==================================

We would like to fix our violation for OCP since our group has hard time to fixed it without crashing down the app. We try to apply idea many idea such as creating a new class that will do stuff and don't change behaviour of main class. However, the app crash and we also violate the independency Inversion Principle. Hence, we push it to "imaginary i4" to deal with that tech debt

Discuss a Feature or User Story that was cut/re-prioritized
============================================

When we work on the app. Some of the features we intially think it will work well actually get combine in other feature such as sheduling task was divided into 3 new features [add task](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/3), [edit task](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/4) and [delete task](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/29). We then assign the high priority for all of them. Moreover, we also combine the feature together, such as calendar view was combine together with add task, so that user can see the calendar while they choosing day for the task they schedule. Thus, we also change [task progress](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/18) from medium prioriy to low priority, and [categorize tasks](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/14) from low priority to high priority. We also add some more feature such as [sorted task by prioriy or date](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/55) as medium prioriy. We also change the way our task notification work. Instead of having dealine, our group all agree the notification will show the high priority task in the day

Acceptance test/end-to-end
==========================
- We test on 5 main things that appear as UI in the app. Creating task, edit task, swipe left change status of task and swipe right to delete task. We also test on how user use sorted mode that the task provide and check how user can see tasks got categorize.
- We using espresso in android studio to fake our interface test. Thus we also add permission in our depencies for gradle so the test can be run on real database. By using esspresso, we can fake user action to do test on interface that we want, such as onclick, typing, and swiping. This is our acceptance file: [Test task](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/commit/31581285a6215bab82f8de7e2138e590ae8a350a), that will include all the test.

Acceptance test, untestable
===============

- The challenge that we face when we creating acceptance that have our database work on that. The reason behind that when we try to run the acceptance test, it give us the error that database has locking problem. We was be able to manage make the database for acceptance test work and its great.
- The test that we found difficult is testing the notification for our task. Due to the notification only create when current day is that day. Hence, if any task create before cannot be done. However, since our task cannot be create in the past, we have to have our acceptance test to create day in the future for the handin. Hence, we didn't include acceptence test for notification, instead, we test on person and the app work fine for notifcation.

Velocity/teamwork
=================
From our Iteration Velocity Chart, we can see the time we actually spent 
on our project nearly twice as long as we estimated for Iteration 1. 
The main reason for this is because most of us are new to the android studio and not familiar with each other. 
We assigned work without understanding each others' strengths and weaknesses, misjudged the situation led to this result. 
For Iteration 2, we made progress based on Iteration 1. We started it early to avoid the previous case 
(unclear division of labour and uneven workload) from happening again. We made it, but we met other problems simultaneously. 
Debugging and made HSQLDB work cost us tons of time, which we have never expected, 
which is why we improved than before but still have some gap between the estimated time 
and actually spent time. By learning the lessons of the previous two iterations, 
we did an excellent job in Iteration 3. 
Although we lack one teammate, the time
we actually spent on our project is less than what we 
estimated, we organized everything well, and everyone did their 
job perfectly. The success of Iteration 3 tells us good communication 
and clear cognition are two essential factors for teamwork, 
which is what this course teaches us besides the theoretical knowledge.

![Velocity](https://user-images.githubusercontent.com/42950390/114966182-a98e5780-9e37-11eb-913a-83260443bfa7.png)
