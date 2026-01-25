package com.example.myapplication.smaple;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.ActivitySampleBinding;

public class SampleActivity extends AppCompatActivity {

    private ActivitySampleBinding binding;

//    private int counter = 0;

    private SampleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySampleBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(SampleViewModel.class);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(binding.sampleFragmentContainer.getId(), SampleFragment.newInstance());
        transaction.commit();

        binding.sampleBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.decreaseCounter();

//                counter = counter-1;
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(binding.sampleFragmentContainer.getId(), SampleFragment.newInstance(counter));
//                transaction.commit();
            }
        });


        binding.sampleBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.increaseCounter();

//                counter = counter+1;
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(binding.sampleFragmentContainer.getId(), SampleFragment.newInstance(counter));
//                transaction.commit();
            }
        });

        viewModel.streamCounter.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

            }
        });
    }
}