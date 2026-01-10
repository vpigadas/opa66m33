package com.example.myapplication.storage.database;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.myapplication.databinding.ActivityDatabaseBinding;

import java.util.List;
import java.util.Random;

public class DatabaseActivity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;
    private DatabaseInstance dbInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbInstance = Room.databaseBuilder(this, DatabaseInstance.class, "UserDatabase")
                .allowMainThreadQueries()
                .build();

        binding.dbInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity user = new UserEntity();
                user.setName(generateName());

                dbInstance.getUserDao().save(user);

                updateUI();
            }
        });

        updateUI();
    }

    private void updateUI() {
        List<UserEntity> users = dbInstance.getUserDao().readAll();

        binding.dbCounterValue.setText(String.valueOf(users.size()));

        binding.dbList.setAdapter(new DatabaseAdapter(users));

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