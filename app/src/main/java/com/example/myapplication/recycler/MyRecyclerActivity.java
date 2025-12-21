package com.example.myapplication.recycler;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMyRecyclerBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerActivity extends AppCompatActivity {

    private ActivityMyRecyclerBinding binding;
    private Boolean clickRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyRecyclerBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.recycler.setAdapter(new MyAdapter(getDataList(), new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!clickRunning){
                    clickRunning = true;
                    Snackbar.make(v, "Row clicked !!!", Snackbar.LENGTH_SHORT).addCallback(new Snackbar.Callback(){
                        @Override
                        public void onDismissed(Snackbar transientBottomBar, int event) {
                            super.onDismissed(transientBottomBar, event);
                            clickRunning = false;
                        }
                    }).show();
                }else {
                    Log.i("RecyclerView", "ignore click event!!!");
                }
            }
        }));
    }

    private List<String> getDataList() {
        List<String> dataList = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            dataList.add(String.valueOf(i));
        }

        return dataList;
    }
}