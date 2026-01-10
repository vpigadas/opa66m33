package com.example.myapplication.storage.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {UserEntity.class}, version = 1)
public abstract class DatabaseInstance extends RoomDatabase {

    public abstract UserDao getUserDao();

}

