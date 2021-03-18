package com.example.myapplication.presentation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.business.AccessTask;
import com.example.myapplication.objects.Task;
import com.example.myapplication.objects.TaskTag;
import com.google.android.material.chip.Chip;

import java.util.List;

public class TabFragment extends Fragment {

    private List<Task> taskList;
    private List<Task> orderedTasks;
    private AccessTask tasks;
    private boolean inAscendingOrder = false;

    public TabFragment() {
    }


    @SuppressLint("FragmentIsValid")
    public TabFragment(List<Task> taskList, AccessTask tasks) {

        this.taskList = taskList;
        this.tasks = tasks;

        orderedTasks = taskList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_fragment_view, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.tabFragmentView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), orderedTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void categorizeTask(TaskTag taskCategory) {
        orderedTasks = tasks.getTasksByTag(taskCategory);
    }


    public void sort() {
        if (!inAscendingOrder) {

            //orderedTasks = tasks.sortPriorityInAsc(orderedTasks);
            orderedTasks = tasks.sortDateInAsc(orderedTasks);
            inAscendingOrder = true;

        } else {

            //orderedTasks = tasks.sortPriorityInDesc(orderedTasks);
            orderedTasks = tasks.sortDateInDesc(orderedTasks);
            inAscendingOrder = false;
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

        private Context context;
        private List<Task> taskList;
        private final String TaskID = "TID";

        public RecyclerViewAdapter(Context context, List<Task> task) {
            this.context = context;
            taskList = task;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

            View view;

            view = LayoutInflater.from(getActivity()).inflate(R.layout.row, viewGroup, false);

            final MyViewHolder viewHolder = new MyViewHolder(view);
            final int sd=i;
            viewHolder.row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int taskId = taskList.get(viewHolder.getAdapterPosition()).getCurrTaskId();

                    Intent viewTask = new Intent(getActivity(), EditActivity.class);

                    viewTask.putExtra("TID", orderedTasks.get(taskId));

                    getActivity().startActivity(viewTask);
                }
            });


            return viewHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

            String title = taskList.get(i).getTaskTitle();
            String description = taskList.get(i).getTaskDescription();
            String date = taskList.get(i).getTaskDate();
            String priority = taskList.get(i).getPriority();


            myViewHolder.taskTitle.setText(title);
            myViewHolder.taskDescription.setText(description);
            myViewHolder.taskDate.setText(date);
            if (priority.equals("True"))
                myViewHolder.taskPriority.setChipBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.red)));

        }

        @Override
        public int getItemCount() {
            return taskList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView taskTitle;
            private TextView taskDescription;
            private TextView taskDate;
            private Chip taskPriority;
            private LinearLayout row;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                taskTitle = (TextView) itemView.findViewById(R.id.taskTitle);
                taskDescription = (TextView) itemView.findViewById(R.id.taskDescription);
                taskDate = (TextView) itemView.findViewById(R.id.taskDate);
                taskPriority = (Chip) itemView.findViewById(R.id.priorityChip);
                row = (LinearLayout) itemView.findViewById(R.id.rowForOneTask);
            }
        }
    }
}
