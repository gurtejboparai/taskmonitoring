What technical debt has been cleaned up
========================================
- Tech debt has been cleaned up is
1. [Empty task can be accept]()
2. [Task can be create in the past]()
3. [app become unreposive when change orentation]()
4. [Data is not available for editing when orientation is horizontal]()
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
- We using espresso in android studio to fake our interface test. Thus we also add permission in our depencies for gradle so the test can be run on real database. By using esspresso, we can fake user action to do test on interface that we want, such as onclick, typing, and swiping. This is our acceptance file: [Test task](), that will include all the test.

Acceptance test, untestable
===============

- The challenge that we face when we creating acceptance that have our database work on that. The reason behind that when we try to run the acceptance test, it give us the error that database has locking problem. We was be able to manage make the database for acceptance test work and its great.
- The test that we found difficult is testing the notification for our task. Due to the notification only create when current day is that day. Hence, if any task create before cannot be done. However, since our task cannot be create in the past, we have to have our acceptance test to create day in the future for the handin. Hence, we didn't include acceptence test for notification, instead, we test on person and the app work fine for notifcation.

Velocity/teamwork
=================

We get better estimate and setting up deadline for our work during the course. In i1, we was very ambious and set deadline way too soon. Hence, we shipped the project while it have a bunch of bug and we couldn't have the test work properly. However, in i2, we have better way to assign work for people, and have most of our task assign finish and pay some tech debt within maintain to meet the requirement of the i2. In i3, we still behind the schedule for a bit. However, we catch up to pay most of our debt, also design new features.
