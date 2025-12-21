package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivitySecondScreenBinding;

public class SecondScreen extends AppCompatActivity {

    private ActivitySecondScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivitySecondScreenBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            if (name != null) {
                Log.d("SecondActivity", name);

                binding.secondTxt.setText(name);
            }
        }

        binding.secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle parameter = new Bundle();
                parameter.putString("name", "Markos");
                parameter.putInt("age", 300);

                Intent intent = new Intent();
                intent.putExtras(parameter);

                setResult(6000, intent);
                finish();
            }
        });
    }
}