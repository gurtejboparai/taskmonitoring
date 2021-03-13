package com.example.myapplication.persistence.hsqldb;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.persistence.TaskPersistence;
import com.example.myapplication.objects.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class TaskPersistenceHSQLDB implements TaskPersistence {
    private final String dbPath;


    public TaskPersistenceHSQLDB(String dbPath)
    {
        this.dbPath = dbPath;
    }


    private Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
        if (connection != null) {

            System.out.println("Connection created successfully");
        } else {

            System.out.println("Problem with creating connection");
        }
        return connection;
    }


    private Task fromResultSet(final ResultSet resultSet) throws SQLException {

        final int taskId = resultSet.getInt("TASKID");

        final String title = resultSet.getString("TITLE");
        final String description = resultSet.getString("DESCRIPTION");
        final String date = resultSet.getString("DATE");

        return new Task(taskId, title, description, date);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int getNewTaskId() {
        int currTaskId;
        int currMaxId = -1;

        List<Task> taskList = getAllTasks();

        for (Task task : taskList)
        {
            currTaskId = task.getCurrTaskId();

            if (currTaskId > currMaxId)
            {
                currMaxId = currTaskId;
            }
        }
        return currMaxId+1;

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Task getTask(int taskId) {

        Task returnTask;

        try (final Connection connection = connection()) {
            final PreparedStatement statement = connection.prepareStatement("SELECT * FROM TASK WHERE TASKID = ?");
            statement.setString(1, String.valueOf(taskId));
            final ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            returnTask = fromResultSet(resultSet);
            resultSet.close();
            statement.close();

            return returnTask;

        } catch (final SQLException e) {

            throw new PersistenceException(e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Task addTask(Task task) {
        try (final Connection connection = connection()) {

            final PreparedStatement statement = connection.prepareStatement("ADD INTO TASK VALUES(?, ?, ?, ?)");

            statement.setInt(1, task.getCurrTaskId());
            statement.setString(2, task.getTaskTitle());
            statement.setString(3, task.getTaskDescription());
            statement.setString(4, task.getTaskDate());

            statement.executeUpdate();
            statement.close();

            return task;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Task deleteTask(Task task) {

        try (final Connection connection = connection()) {
            final PreparedStatement sc = connection.prepareStatement("DELETE FROM TASK WHERE TASKID = ?");
            sc.setString(1, String.valueOf(task.getCurrTaskId()));
            sc.executeUpdate();
            sc.close();
            return task;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void editTask(Task task) {

        try (final Connection connection = connection()) {

            final PreparedStatement statement = connection.prepareStatement("UPDATE TASK SET TITLE = ?, DESCRIPTION = ?,"
                    + " DATE = ? WHERE TASKID = ?");

            statement.setString(1, task.getTaskTitle());
            statement.setString(2, task.getTaskDescription());
            statement.setString(3, task.getTaskDate());
            statement.setInt(4, task.getCurrTaskId());

            statement.executeUpdate();

        } catch (final SQLException e) {

            throw new PersistenceException(e);
        }

    }

    @Override
    public boolean checkForSame(Task task1, Task task2) {
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void setStatus(Task task, String newStatus) {

        try (final Connection connection = connection()) {
            final PreparedStatement statement = connection.prepareStatement("UPDATE TASK SET NEWSTATUS =?, WHERE TASKID = ?");

            statement.setString(1, task.getStatus());

            statement.setInt(2, task.getCurrTaskId());

            statement.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void setTaskDate(Task task, String taskDate) {

        try (final Connection connection = connection()) {
            final PreparedStatement statement = connection.prepareStatement("UPDATE TASK SET DATE = ? WHERE TASKID = ?");

            statement.setString(1, taskDate);
            statement.setInt(2, task.getCurrTaskId());

            statement.executeUpdate();

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public List<Task> getAllTasks() {

        List<Task> tasks = new ArrayList<>();

        try (final Connection connection = connection()) {

            final Statement st = connection.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM TASKS");

            while (rs.next()) {
                final Task task = fromResultSet(rs);
                tasks.add(task);
            }

            rs.close();
            st.close();

            return tasks;

        } catch (final SQLException e) {

            throw new PersistenceException(e);
        }
    }
}

