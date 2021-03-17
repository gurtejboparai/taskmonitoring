//package com.example.myapplication.presentation;
//
//import android.content.Context;
//import android.content.Intent;
//
//import androidx.annotation.ColorInt;
//import androidx.annotation.NonNull;
//import androidx.core.content.ContextCompat;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.res.ColorStateList;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.example.myapplication.objects.Task;
//import com.example.myapplication.R;
//import com.google.android.material.chip.Chip;
//
//import java.util.List;
//
//public class RecyclerViewAdapter extends RecyclerView.Adapter<com.example.myapplication.presentation.RecyclerViewAdapter.MyViewHolder> {
//
//    private Context context;
//    private List<Task> taskList;
//    private final String TaskID = "TID";
//
//    public RecyclerViewAdapter(Context context, List<Task> task) {
//        this.context = context;
//        taskList = task;
//    }
//
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//
//        View view;
//
//        view = LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false);
//
//        final MyViewHolder viewHolder = new MyViewHolder(view);
//
//        viewHolder.row.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//
//                int taskId = taskList.get(viewHolder.getAdapterPosition()).getCurrTaskId();
//
//                Intent viewTask = new Intent(context, Task.class);
//
//                viewTask.putExtra(TaskID, taskId);
//
//                context.startActivity(viewTask);
//            }
//        });
//
//
//        return viewHolder;
//    }
//
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//
//        String title = taskList.get(i).getTaskTitle();
//        String description = taskList.get(i).getTaskDescription();
//        String date = taskList.get(i).getTaskDate();
//        String priority = taskList.get(i).getPriority();
//
//
//        myViewHolder.taskTitle.setText(title);
//        myViewHolder.taskDescription.setText(description);
//        myViewHolder.taskDate.setText(date);
//        if(priority.equals("True"))
//        myViewHolder.taskPriority.setChipBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.red)));
//
//    }
//
//
//    @Override
//    public int getItemCount()
//    {
//        return taskList.size();
//    }
//
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        private TextView taskTitle;
//        private TextView taskDescription;
//        private TextView taskDate;
//        private Chip taskPriority;
//        private LinearLayout row;
//
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            taskTitle = (TextView) itemView.findViewById(R.id.taskTitle);
//            taskDescription = (TextView) itemView.findViewById(R.id.taskDescription);
//            taskDate = (TextView) itemView.findViewById(R.id.taskDate);
//            taskPriority = (Chip) itemView.findViewById(R.id.priorityChip);
//            row = (LinearLayout) itemView.findViewById(R.id.rowForOneTask);
//        }
//    }
//}
