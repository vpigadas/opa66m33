package com.example.myapplication.storage.database.v2;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.myapplication.storage.database.DatabaseInstance;
import com.example.myapplication.storage.database.UserEntity;

import java.util.List;

public class DatabaseViewmodel extends ViewModel {

    private DatabaseInstance dbInstance;

    private MutableLiveData<List<UserEntity>> _streamUsers = new MutableLiveData<>();
    public LiveData<List<UserEntity>> streamUsers = _streamUsers;

    public void initialize(Context context) {
        this.dbInstance = Room.databaseBuilder(context.getApplicationContext(), DatabaseInstance.class, "UserDatabase")
                .allowMainThreadQueries()
                .build();

        _streamUsers.postValue(retrieveData());
    }

    public void save(UserEntity data) {
        dbInstance.getUserDao().save(data);

        _streamUsers.postValue(retrieveData());
//        _streamUsers.setValue(retrieveData());
    }

    public List<UserEntity> retrieveData() {
        return dbInstance.getUserDao().readAll();
    }


}
