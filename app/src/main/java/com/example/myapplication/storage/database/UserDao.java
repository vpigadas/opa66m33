package com.example.myapplication.storage.database;

import android.database.SQLException;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insert(UserEntity user) throws SQLException;

    @Update
    public void update(UserEntity user) throws SQLException;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(UserEntity user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(List<UserEntity> users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveAll(List<UserEntity> users);

    @Delete
    public void delete(UserEntity user);

    @Delete
    public void delete(List<UserEntity> user);

    @Query("SELECT * FROM User")
    @NotNull
    public List<UserEntity> readAll();

    @Query("SELECT * FROM User")
    @NotNull
    public LiveData<List<UserEntity>> streamReadAll();


    @Query("SELECT * FROM User LIMIT 1")
    @Nullable
    public UserEntity readFirst();

    @Query("SELECT * FROM User WHERE user_name LIKE :name")
    @NonNull
    public List<UserEntity> readByName(String name);

    @Query("SELECT * FROM User WHERE user_name LIKE :name AND age = :age")
    @NonNull
    public List<UserEntity> readNameAndAge(String name, int age);

}
