package com.example.myapplication.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String titles[];
    String descriptions[];
    Context context;
    public MyAdapter(Context ct,String titles[],String descriptions[])
    {
        context=ct;
        this.titles=titles;
        this.descriptions=descriptions;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.titlesView.setText(titles[position]);
    holder.descriptionsView.setText(descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titlesView,descriptionsView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titlesView=itemView.findViewById(R.id.titlesView);
            descriptionsView=itemView.findViewById(R.id.descriptionsView);

        }
    }
}
