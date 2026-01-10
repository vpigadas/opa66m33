package com.example.myapplication.storage.database;

import android.database.SQLException;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insert(UserEntity user) throws SQLException;

    @Update
    public void update(UserEntity user) throws SQLException;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(UserEntity user);

    @Delete
    public void delete(UserEntity user);

    @Query("SELECT * FROM User")
    @NotNull
    public List<UserEntity> readAll();

}
