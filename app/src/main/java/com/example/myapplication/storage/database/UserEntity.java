package com.example.myapplication.storage.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity( tableName = "User")
public class UserEntity {

    @PrimaryKey( autoGenerate = true)
    private int id;

    @ColumnInfo( name = "user_name")
    private String name;

    @ColumnInfo(name = "age")
    private int age;

    @ColumnInfo(name ="job_title")
    private String jobTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob_title() {
        return jobTitle;
    }

    public void setJob_title(String job_title) {
        this.jobTitle = job_title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;
        return id == that.id && age == that.age && Objects.equals(name, that.name) && Objects.equals(jobTitle, that.jobTitle);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + age;
        result = 31 * result + Objects.hashCode(jobTitle);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", job_title='" + jobTitle + '\'' +
                '}';
    }
}
