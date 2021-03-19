package com.example.myapplication.persistence.hsqldb;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.objects.Task;
import com.example.myapplication.persistence.TaskPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskPersistenceHSQLDB implements TaskPersistence {
    private final String dbPath;
//    private final String dbScriptName;
    // private List<Task>taskList;
    public TaskPersistenceHSQLDB(final String dbPath){
        this.dbPath=dbPath;
//        this.dbScriptName = dbScriptName;
        // taskList = new ArrayList<>();
    }
    private Connection connection() throws SQLException, ClassNotFoundException {
        // Class.forName("org.hsqldb.jdbcDriver");
//        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath+ ";shutdown=true", "SA", "");
        System.out.println("jdbc:hsqldb:file:" + dbPath+ ";shutdown=true");
        Connection connection =  DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath+ ";shutdown=true", "SA", "");
        if (connection != null) {
            System.out.println("connection done.");
        }
        else {
            System.out.println("Fail when connecting to HSQLDB");
        }

        return connection;
    }

    private Task fromResultSet(final ResultSet rs) throws SQLException {
        final int taskId = rs.getInt("taskId");
        final String taskTitle = rs.getString("taskTitle");
        final String taskDescription = rs.getString("taskDescription");
        final String taskDay = rs.getString("taskDate");
        final String taskPriority = rs.getString("taskPriority");
        final String taskTag = rs.getString("taskTag");
        final String taskStatus = rs.getString("taskStatus");
        return new Task(taskId,taskTitle,taskDescription,taskDay,taskTag,taskStatus,taskPriority);
    }



//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    public void addTasks() {
//        try (final Connection c = connection()) {
//            final Statement st = c.createStatement();
//            final ResultSet rs = st.executeQuery("SELECT * FROM TASK");
//            while (rs.next()) {
//                final Task task = fromResultSet(rs);
//                taskList.add(task);
//            }
//            rs.close();
//            st.close();
//        } catch (final SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }

    @Override
    public int getNewTaskId() {
        int currentMaxId = -1;
        int currentId;

        List<Task> tasks = getAllTasks();

        for ( Task task : tasks) {
            currentId = task.getCurrTaskId();

            if ( currentId > currentMaxId) {
                currentMaxId = currentId;
            }
        }

        return currentMaxId + 1;
    }

    @Override
    public Task getTask(int taskId) {
//        Task result =null;
//        for(Task task: taskList){
//            if(task.getCurrTaskId()==taskId)
//                result=task;
//        }
//        return result;

        Task result;

        try (final Connection c = connection())
        {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM TASK WHERE taskId = ?");
            st.setString(1, String.valueOf(taskId));
            final ResultSet rs = st.executeQuery();

            rs.next();
            result = fromResultSet(rs);
            rs.close();
            st.close();

            return result;
        }catch (final SQLException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    }

//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Task addTask(Task task) {
        System.out.println("task - id:" + task.getCurrTaskId());
        System.out.println("task - getTaskTitle:" + task.getTaskTitle());

        System.out.println("task - getTaskDescription:" + task.getTaskDescription());
        System.out.println("task - getTaskDate:" + task.getTaskDate());
        System.out.println("task - getTaskTag:" + task.getTaskTag().toString());
        System.out.println("task - getStatus:" + task.getStatus());
        System.out.println("task - getPriority:" + task.getPriority());


        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO TASK VALUES(?,?,?,?,?,?,?)");
            st.setInt(1,task.getCurrTaskId());
            st.setString(2,task.getTaskTitle());
            st.setString(3,task.getTaskDescription());
            st.setString(4, task.getTaskDate());
            st.setString(5,task.getTaskTag().toString());
            st.setString(6, task.getStatus());
            st.setString(7,task.getPriority());
            st.executeUpdate();
//            taskList.add(task);
            return task;
        }catch (final SQLException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    }

//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Task deleteTask(Task task) {
        try( final Connection c = connection()){
            final PreparedStatement st= c.prepareStatement("DELETE FROM TASK WHERE taskId= ?");
            st.setString(1, String.valueOf(task.getCurrTaskId()));
            st.executeUpdate();
            st.close();
//            taskList.remove(task);
        }
        catch (final SQLException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
        return task;
    }

//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void editTask(Task task, Task newTask) {
        try(final Connection c= connection()){
            final PreparedStatement st = c.prepareStatement("UPDATE TASK SET taskTitle= ?, taskDescription= ?, taskDate= ?, taskTag= ?, taskStatus= ? taskPriority=? WHERE taskId= ?");
            st.setString(1,newTask.getTaskTitle());
            st.setString(2,newTask.getTaskDescription());
            st.setString(3,newTask.getTaskDate());
            st.setString(4,newTask.getTaskTag().toString());
            st.setString(5,newTask.getStatus());
            st.setString(6,newTask.getPriority());
            st.setInt(7,task.getCurrTaskId());
            st.executeUpdate();
        }
        catch (final SQLException | ClassNotFoundException e){
            throw new RuntimeException((e.getMessage()));
        }
    }

    @Override
    public boolean checkForSame(Task task1, Task task2) {
        return task1.getCurrTaskId() == task2.getCurrTaskId();
    }

//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void setStatus(Task task, String newStatus) {
        try(final Connection c= connection()){
            final PreparedStatement st= c.prepareStatement("UPDATE TASK SET taskStatus= ? WHERE taskId = ?");
            st.setString(1,newStatus);
            st.setInt(2,task.getCurrTaskId());
            st.executeUpdate();

        }
        catch (final SQLException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }

    }

//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void setTaskDate(Task tak, String taskDate) {
        try(final Connection c= connection()){
            final PreparedStatement st=c.prepareStatement("UPDATE TASK SET taskDate= ? WHERE taskId= ?");
            st.setString(1, taskDate);
            st.setInt(2,tak.getCurrTaskId());
            st.executeUpdate();
        }
        catch(final SQLException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }

    }

//    @RequiresApi(api = Build.VERSION_CODES.KITKAT )
    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM TASK");
            while (rs.next())
            {
                final Task task = fromResultSet(rs);
                tasks.add(task);
            }
            rs.close();
            st.close();

            return tasks;
        }
        catch (final SQLException | ClassNotFoundException e)
        {
//            throw new PersistenceException(e);
            throw new RuntimeException(e.getMessage());
        }

    }
}

