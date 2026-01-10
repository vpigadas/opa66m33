package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.network.NetworkActivity;
import com.example.myapplication.recycler.MyRecyclerActivity;
import com.example.myapplication.storage.StorageActivity;
import com.example.myapplication.storage.database.DatabaseActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

//        Button button = findViewById(R.id.main_btn_first);

        binding.mainBtnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "user press a button !!!");
            }
        });
        binding.mainBtnFirst.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("MainActivity", "user long click event button !!!");
                return true;
            }
        });

        binding.mainBtnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                intent.putExtra("name", "Vassilis");
                intent.putExtra("age", 100);

                Bundle parameter = new Bundle();
                parameter.putString("name", "Vassilis");
                parameter.putInt("age", 100);
                intent.putExtras(parameter);

//                startActivity(intent);
                startActivityForResult(intent, 5000);
            }
        });

        binding.mainBtnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyRecyclerActivity.class);
                startActivity(intent);
            }
        });

        binding.mainBtnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
            }
        });

        binding.mainBtnStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StorageActivity.class);
                startActivity(intent);
            }
        });

        binding.mainBtnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(intent);
            }
        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("MainActivity", "user press a button !!!");
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (data != null) {
            Log.d("MainActivity", "requestCode:" + requestCode + " resultCode:" + resultCode + " intent" + data.toString());

            Bundle extras = data.getExtras();

            if (extras != null) {
                String name = extras.getString("name");
                int age = extras.getInt("age");

                Log.d("MainActivity", "name:" + name + " age:" + age);
            }

        } else {
            Log.d("MainActivity", "requestCode:" + requestCode + " resultCode:" + resultCode);
        }

        super.onActivityResult(requestCode, resultCode, data);


    }
}