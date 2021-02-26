## Adding a feature
-----------------
After coming up with all possible features we can implement for the project. This is one of the stories about how the [Schedule Tasks feature](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/9)(our first feature) got added. In this journey, we using our [user story #1](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/3) and [user’s story #2](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/4), which both assigned for Yanjia Wang. However, each user story broke down to various dev tasks and assigned to each member of the group, which are included in the description of each user’s story.
This was the most important feature in the whole project that needed to be implemented at first. Unfortunately, when we did the feature, our group still struggled in defining the way of branching strategy that we wanted to use. Hence, we did not have a specific merge request for that. However, our group has meetings every week, and communicate through group chat (discord) to update and let other group members review the code. Therefore, the progress of working on the project did not get delayed while we looked for the suitable branching strategy (Github Flow).
## Exceptional code
----------------
We test exception code on invalid number of Day.class variables, since day of the year cannot be negative, bigger than 30.
[This is the link for our exceptional code](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/commit/1f61988758b1be775390783e91cba65bd6cef6c0)
## Branching
----------

[This is the link]() to describe our strategy. New branch with specific work assigned was create, then it got merged into the master branch, and the deployed branch was deleted.

<img width="468" alt="Picture1" src="https://user-images.githubusercontent.com/42950390/109312965-486dde80-780d-11eb-8715-5c5687977e2b.png">
## SOLID
----------------

After going through group 5 branching and issue, we recognize that group 5 was violated on single responsibility principle in SOLID principle. Hence their  issue does not declare clearly what they did in each dev task, as well as in the user’s stories, we did not have strong evidence for their violation. However, our group believe this link [#1](https://code.cs.umanitoba.ca/3350-winter-2021-a03/group5app-comp3350-a03-group5/-/issues/10) and this link [#2] (https://code.cs.umanitoba.ca/3350-winter-2021-a03/group5app-comp3350-a03-group5/-/issues/13) can prove that they violate the  principle. They have a class that creates a task List and a class that creates a list of task lists. Following the single responsibility principle, we think the 2 list for tasks is not necessary because they reflect the same thing, which is creating the list of tasks.
## Agile Planning
--------------
In the progress of working on iteration 1, we have planned for each dev will be done on a specific day, as well as how the feature should be posted on a specific day. For example, we were planning to have all the storage classes  ready after the due day of iteration 0. However, our group struggled to plan the idea of how the skeleton of the coding will look, as well as implementation strategy for the project. Hence, we have some delay in release day, and have to change the due date to another day in order to have it meet the deadline assigned . On the bright side, each feature that we assign to work on iteration 1 was finished on time, and we did not have to change the description of any feature or user stories that have been assigned to be finished in iteration 1. Unfortunately, since our group is still learning slowly about the coding and the algorithm that we will use for the project, we did not post anything that connects to iteration 2.
