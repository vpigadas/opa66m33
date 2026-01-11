package com.example.myapplication.storage.database.v2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.ActivityDatabaseBinding;
import com.example.myapplication.storage.database.DatabaseAdapter;
import com.example.myapplication.storage.database.UserEntity;

import java.util.List;
import java.util.Random;

public class DatabaseV2Activity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;
    private DatabaseViewmodel viewmodel;
    private DatabaseViewmodelWithContext viewmodel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        viewmodel = new ViewModelProvider(this).get(DatabaseViewmodel.class);
        viewmodel2 = new ViewModelProvider(this).get(DatabaseViewmodelWithContext.class);

        viewmodel.initialize(this);
        viewmodel2.initialize();

        binding.dbInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity user = new UserEntity();
                user.setName(generateName());

//                viewmodel.save(user);
                viewmodel2.save(user);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

//        viewmodel.streamUsers.observe(this, new Observer<List<UserEntity>>() {
//            @Override
//            public void onChanged(List<UserEntity> userEntities) {
//                binding.dbCounterValue.setText(String.valueOf(userEntities.size()));
//
//                binding.dbList.setAdapter(new DatabaseAdapter(userEntities));
//            }
//        });

        viewmodel2.streamUsers.observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> userEntities) {
                binding.dbCounterValue.setText(String.valueOf(userEntities.size()));

                binding.dbList.setAdapter(new DatabaseAdapter(userEntities));
            }
        });
    }

    @Override
    protected void onPause() {
        viewmodel.streamUsers.removeObservers(this);
        viewmodel2.streamUsers.removeObservers(this);
        super.onPause();
    }

    private String generateName() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 16) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}