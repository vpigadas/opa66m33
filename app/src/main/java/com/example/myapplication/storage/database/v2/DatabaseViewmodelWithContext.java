package com.example.myapplication.storage.database.v2;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.myapplication.storage.database.DatabaseInstance;
import com.example.myapplication.storage.database.UserEntity;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseViewmodelWithContext extends AndroidViewModel {

    private DatabaseInstance dbInstance;

    public LiveData<List<UserEntity>> streamUsers;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private ExecutorService executorServices = Executors.newFixedThreadPool(4);
    private ExecutorService executorServicess = Executors.newWorkStealingPool(4);

    private Looper myLoop = Looper.myLooper();
    private Handler handler = new Handler(myLoop);

    public DatabaseViewmodelWithContext(@NonNull Application application) {
        super(application);
    }

    public void initialize() {
        this.dbInstance = Room.databaseBuilder(getApplication(), DatabaseInstance.class, "UserDatabase")
                .build();

        streamUsers = dbInstance.getUserDao().streamReadAll();
    }

    public void save(UserEntity data) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                dbInstance.getUserDao().save(data);
            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {
                dbInstance.getUserDao().save(data);
            }
        });
    }

    @Override
    protected void onCleared() {
        executorService.shutdown();

        handler.removeCallbacks(null);
        myLoop.quit();
        super.onCleared();
    }
}







