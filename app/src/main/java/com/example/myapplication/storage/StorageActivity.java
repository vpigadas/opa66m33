package com.example.myapplication.storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityStorageBinding;

public class StorageActivity extends AppCompatActivity {

    private ActivityStorageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStorageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("user_information", MODE_PRIVATE);

        binding.storageDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("counter", sharedPreferences.getInt("counter", 0) - 1);
                editor.apply();

                updateUi(sharedPreferences);
            }
        });

        binding.storageIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("counter", sharedPreferences.getInt("counter", 0) + 1);
                editor.apply();

                updateUi(sharedPreferences);
            }
        });

        updateUi(sharedPreferences);

//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("name", "Vassilis");
//        editor.putInt("counter", 1);
//
//        //editor.commit();
//        editor.apply();
    }

    private void updateUi(SharedPreferences preferences) {

        binding.storageCounter.setText(String.valueOf(preferences.getInt("counter", 0)));
    }
}