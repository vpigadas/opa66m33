package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMyFragmentBinding;

public class MyFragmentActivity extends AppCompatActivity {

    private ActivityMyFragmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyFragmentBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_my_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(
                binding.fragmentContainerV2.getId(),
                FirstFragment.newInstance()
        );
        transaction.commit();

        FragmentTransaction transactionv2 = fragmentManager.beginTransaction();
        transactionv2.replace(
                binding.fragmentContainer.getId(),
                FirstFragment.newInstance()
        );
        transactionv2.commit();
    }
}