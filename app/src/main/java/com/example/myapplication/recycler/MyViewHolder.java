package com.example.myapplication.recycler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.HolderFirstRowBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private HolderFirstRowBinding binding;

    public MyViewHolder(@NonNull HolderFirstRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String data) {
        binding.holderFirstTxt.setText(data);
    }
}
