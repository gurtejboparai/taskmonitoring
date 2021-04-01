package com.example.myapplication.presentation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.business.AccessTask;
import com.example.myapplication.objects.Task;
import com.example.myapplication.objects.TaskTag;
import com.google.android.material.chip.Chip;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class TabFragment extends Fragment {

    private List<Task> taskList;
    private List<Task> orderedTasks;
    private AccessTask tasks;

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
        final RecyclerView recyclerView = view.findViewById(R.id.tabFragmentView);
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), orderedTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        final String[] deletedTask = {null};
        final Task[] task = {null};
        final String[] label = {"Done"};
        ItemTouchHelper.SimpleCallback simpleCallback =new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT)
        {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final int pos = viewHolder.getAdapterPosition();
                task[0] = taskList.get(pos);
                switch (direction) {
                    case ItemTouchHelper.LEFT:
                        deletedTask[0] = task[0].getTaskTitle();
                        taskList.remove(pos);
                        tasks.deleteTask(task[0]);
                        recyclerViewAdapter.notifyItemRemoved(pos);
                        Snackbar.make(recyclerView, deletedTask[0], Snackbar.LENGTH_LONG)
                                .setAction("Undo", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        taskList.add(pos, task[0]);
                                        tasks.addTask(task[0]);
                                        recyclerViewAdapter.notifyItemInserted(pos);
                                    }
                                }).show();
                        break;

                    case ItemTouchHelper.RIGHT:
                        if(task[0].getStatus().equals("completed"))
                        {
                            tasks.setStatus(task[0],"on going");
                            label[0]="Done";
                        }
                        else {
                            tasks.setStatus(task[0],"completed");
                            label[0]="On going";
                        }
                        recyclerViewAdapter.notifyItemChanged(pos);
                        break;
                }
                Intent homepage = new Intent(getActivity(), ViewTaskActivity.class);
                startActivity(homepage);

            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive)
            {
                new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        .addSwipeLeftBackgroundColor(ContextCompat.getColor(getContext(),R.color.red))
                        .addSwipeLeftLabel("Delete")
                        .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                        .addSwipeRightBackgroundColor(ContextCompat.getColor(getContext(),R.color.green))
                        .addSwipeRightLabel(label[0])
                        .addSwipeRightActionIcon(R.drawable.ic_baseline_done_24)
                        .create()
                        .decorate();
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }

        };

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void sortDefault(){
        orderedTasks = tasks.sortDefault(orderedTasks);
    }

    public void sortPrioA() {
        orderedTasks = tasks.sortPriorityInAsc(orderedTasks);
    }

    public void sortPrioD(){
        orderedTasks = tasks.sortPriorityInDesc(orderedTasks);
    }

    public void sortDateA(){
        orderedTasks = tasks.sortDateInAsc(orderedTasks);
    }

    public void sortDateD(){
        orderedTasks = tasks.sortDateInDesc(orderedTasks);
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

        private final Context context;
        private final List<Task> taskList;

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

            viewHolder.row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int taskId = taskList.get(viewHolder.getAdapterPosition()).getCurrTaskId();

                    Intent viewTask = new Intent(getActivity(), EditActivity.class);

                    viewTask.putExtra("TID", taskId);

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
            String status=taskList.get(i).getStatus();


            myViewHolder.taskTitle.setText(title);
            myViewHolder.taskDescription.setText(description);
            myViewHolder.taskDate.setText(date);
            if (priority.equals("True"))
                myViewHolder.taskPriority.setChipBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.OrangeRed)));
            if(status.equals("completed")) {
                myViewHolder.taskTitle.setPaintFlags(myViewHolder.taskTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }

        }

        @Override
        public int getItemCount() {
            return taskList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            private final TextView taskTitle;
            private final TextView taskDescription;
            private final TextView taskDate;
            private final Chip taskPriority;
            private final LinearLayout row;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                taskTitle = itemView.findViewById(R.id.taskTitle);
                taskDescription = itemView.findViewById(R.id.taskDescription);
                taskDate = itemView.findViewById(R.id.taskDate);
                taskPriority = itemView.findViewById(R.id.priorityChip);
                row = itemView.findViewById(R.id.rowForOneTask);
            }
        }
    }
}
