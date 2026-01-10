package com.example.myapplication.storage.database;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.HolderFirstRowBinding;

public class DatabaseViewHolder extends RecyclerView.ViewHolder {

    private HolderFirstRowBinding binding;

    public DatabaseViewHolder(@NonNull HolderFirstRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(UserEntity user) {
        binding.holderFirstTxt.setText(user.getName());
    }
}
