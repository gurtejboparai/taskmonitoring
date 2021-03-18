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
    private final String dbScriptName;
    private List<Task>taskList;
    public TaskPersistenceHSQLDB(final String dbPath, final String dbScriptName){
        this.dbPath=dbPath;
        this.dbScriptName = dbScriptName;
        taskList = new ArrayList<>();
    }
    private Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath+dbScriptName+ ";shutdown=true", "SA", "");
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



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addTasks() {
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM TASK");
            while (rs.next()) {
                final Task task = fromResultSet(rs);
                taskList.add(task);
            }
            rs.close();
            st.close();
        } catch (final SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int getNewTaskId() {
        int count = taskList.size();
        count+=1;
        return count;
    }

    @Override
    public Task getTask(int taskId) {
        Task result =null;
        for(Task task: taskList){
            if(task.getCurrTaskId()==taskId)
                result=task;
        }
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Task addTask(Task task) {
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO TASK VALUE(?,?,?,?,?,?,?)");
            st.setInt(1,task.getCurrTaskId());
            st.setString(2,task.getTaskTitle());
            st.setString(3,task.getTaskDescription());
            st.setString(4, task.getTaskDate());
            st.setString(5,task.getTaskTag().toString());
            st.setString(6, task.getStatus());
            st.setString(7,task.getPriority());
            st.executeUpdate();
            taskList.add(task);
            return task;
        }catch (final SQLException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Task deleteTask(Task task) {
        try( final Connection c = connection()){
            final PreparedStatement st= c.prepareStatement("DELETE FROM TASK WHERE taskId= ?");
            st.setInt(1, task.getCurrTaskId());
            st.executeUpdate();
            taskList.remove(task);
        }
        catch (final SQLException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT )
    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }
}

