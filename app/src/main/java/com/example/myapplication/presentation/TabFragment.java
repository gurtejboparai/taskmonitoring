package com.example.myapplication.presentation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.business.AccessTask;
import com.example.myapplication.objects.Task;
import com.example.myapplication.objects.TaskTag;

import java.util.List;

public class TabFragment extends Fragment {

    private List<Task> taskList;
    private List<Task> orderedTasks;
    private AccessTask tasks;
    private boolean inAscendingOrder = false;

    public TabFragment() {}


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
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), orderedTasks);
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

}
