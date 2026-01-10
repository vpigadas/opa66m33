package com.example.myapplication.storage.database;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.HolderFirstRowBinding;

import java.util.List;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseViewHolder> {

    private List<UserEntity> userEntities;

    public DatabaseAdapter(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    @NonNull
    @Override
    public DatabaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HolderFirstRowBinding binding = HolderFirstRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DatabaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseViewHolder holder, int position) {
        holder.bind(userEntities.get(position));
    }

    @Override
    public int getItemCount() {
        return userEntities.size();
    }
}
