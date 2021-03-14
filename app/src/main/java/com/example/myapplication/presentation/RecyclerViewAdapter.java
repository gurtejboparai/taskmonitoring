package com.example.myapplication.presentation;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.objects.Task;
import com.example.myapplication.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<com.example.myapplication.presentation.RecyclerViewAdapter.MyViewHolder> {

    private Context myContext;
    private List<Task> myTask;

    private final String TaskID = "TaskID";

    public RecyclerViewAdapter(Context context, List<Task> task) {
        myContext = context;
        myTask = task;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        view = LayoutInflater.from(myContext).inflate(R.layout.row, viewGroup, false);

        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.row.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                int taskId = myTask.get(viewHolder.getAdapterPosition()).getCurrTaskId();

                Intent viewAd = new Intent(myContext, Task.class);

                viewAd.putExtra(TaskID, taskId);
                myContext.startActivity(viewAd);
            }
        });


        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        String title = myTask.get(i).getTaskTitle();
        String description = myTask.get(i).getTaskDescription();
        String date = myTask.get(i).getTaskDate();
        String priority = myTask.get(i).getTaskDate();


        myViewHolder.taskTitle.setText(title);
        myViewHolder.taskDescription.setText(description);
        myViewHolder.taskDate.setText(date);
        //myViewHolder.taskPriority.setText(priority);

    }


    @Override
    public int getItemCount()
    {
        return myTask.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView taskTitle;
        private TextView taskDescription;
        private TextView taskDate;
        //private TextView taskPriority;
        private LinearLayout row;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            taskTitle = (TextView) itemView.findViewById(R.id.taskTitle);
            taskDescription = (TextView) itemView.findViewById(R.id.taskDescription);
            taskDate = (TextView) itemView.findViewById(R.id.taskDate);
            //taskPriority = (TextView) itemView.findViewById(R.id.taskPriority);
            row = (LinearLayout) itemView.findViewById(R.id.rowForOneTask);
        }
    }
}
