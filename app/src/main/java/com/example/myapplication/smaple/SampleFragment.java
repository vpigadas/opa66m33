package com.example.myapplication.smaple;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentSampleBinding;


public class SampleFragment extends Fragment {

    public SampleFragment() {
        // Required empty public constructor
    }

    public static SampleFragment newInstance() {
        SampleFragment fragment = new SampleFragment();
        return fragment;
    }

    public static SampleFragment newInstance(int counter) {
        SampleFragment fragment = new SampleFragment();
        Bundle parameter = new Bundle();
        parameter.putInt("counter", counter);
        fragment.setArguments(parameter);
        return fragment;
    }

    private FragmentSampleBinding binding;

    private SampleViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getActivity() != null) {
            viewModel = new ViewModelProvider(getActivity()).get(SampleViewModel.class);
        } else {
            viewModel = new ViewModelProvider(this).get(SampleViewModel.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSampleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fragmentCounter.setText("1234567890");

        if (getArguments() != null) {
            binding.fragmentCounter.setText(String.valueOf(getArguments().getInt("counter", 0)));
        }

        viewModel.streamCounter.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.fragmentCounter.setText(String.valueOf(integer));
            }
        });
    }
}