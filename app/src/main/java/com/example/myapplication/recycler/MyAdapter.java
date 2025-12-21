package com.example.myapplication.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.HolderFirstRowBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<String> dataList;

    public MyAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        HolderFirstRowBinding binding = HolderFirstRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = binding.getRoot();

        return new MyViewHolder(binding);
//        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
