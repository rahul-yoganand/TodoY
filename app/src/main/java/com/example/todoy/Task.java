package com.example.todoy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    int uid;
    @ColumnInfo
    String taskTitle;
    public Task(String taskTitle) {
        this.taskTitle = taskTitle;
    }
    public String toString() {
        return taskTitle;
    }
}
