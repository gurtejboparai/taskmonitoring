# Iteration 2 Worksheet
## Paying off technical debt
---------------------------------------
### First technical debt: The UI of the app
- We think this is our technical debt because in i1, our UI got designed poorly, thus, most of the important function in the interface design does not seem to be working. However, none of us has time to find the best way to fix it due to the deadline, and we could not have enough time to learn about the UI and apply it at the same time (problem with time management). Hence, we just want to finish the requirement and "ship" the iteration 1. However, we learn that UI is the life of our app, and we need to have the UI working as soon as possible to handle the backend of the project. We think this technical debt is deliberate prudent tech debt, in other words, we have to post the product and face the consequence. [You can find the UI got handle here](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/commit/6a97d73a6375948b3e6ac4eb72f0c3aa67a92d54)

### Second technical debt: The Test files throw error
- Test files are important. However, we messed up on it in i1. However, we don't have to restructure the whole test files data, we just need to figure out which causes our test file to crash and fix some minor issues why our tests fail. We all agreed in the group meeting this is a technical debt and it a deliberate prudent technical debt. In other words, we know there are errors with our test files, but we have to submit the project due to the deadline. However, we start looking through the gradle and figure out which causes the crash in our test after the deadline and be able to fix it quickly. [You can see the error got handle here](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/commit/bb09f6313c24084f4451c0c6fc3319570490af34)

## Retrospective
---------------------------------------------
Retrospective is necessary for our group in changing ideas and managing our time better. We have a much better understanding of how much time each group member has to spend in the second iteration, as well as what each member wants to do in the second iteration. Moreover, one of our groupmate also has the time to talk with Lauren (our instructor for the course). Hence, we made a lot of modifications in our project so that the project can be improved and develop in the right track. However, we don't have the evidence for these because the Retrospective happens during group meetings and the private meeting between our groupmate and instructor.

## Design patterns
-----------------------------------------------
In the project, for [task class object/logic layer](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/blob/master/app/src/main/java/com/example/myapplication/objects/Task.java), we all agree that we depend heavily on [singleton](https://refactoring.guru/design-patterns/singleton), we don't provide global access varibales, instead, we use the instance for client to call each varibales in task class or access task class. However, since there is only 1 class provide these instance for client, instead of building from different class, it not a builder.

## Solid principle
-------------------------------------
[Solid principle for group 4 section A01](https://code.cs.umanitoba.ca/3350-winter-2021-a01/weBudget/-/issues)


## Feedback fixes in iteration 1
----------------------------------------------
### Add task and view task does not connect
We choose this the first issue to work with because adding task to list is one of our most crucial part in the project. We have to restructure the whole XHTML file for ViewTask and AddTask,yet, we modify the whole 2 java files that connect with it. Therefore, we are most likely to redo everything and make sure thing work in the right way. The reason we  think the error occur because  when we first start i1, none of us has experience in working with XHTML as well as handle the big project, so we have no idea what is going on. However, after the feedback from i1, thus, our own time to learn about UI design. We have better knowledge and know what to do.
[You can see the error here](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/issues/36) and  [this is how we deal with](https://code.cs.umanitoba.ca/3350-winter-2021-a03/taskmonitoring-group4-comp3350-a03-winter2021/-/commit/3a28c1b6c618682e3f7e8ddd698e9cb7a21a28ac)
