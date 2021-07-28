package com.example.todoy;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class TaskRoomDb extends RoomDatabase {
    public abstract TaskDao taskDao();
    public static TaskRoomDb INSTANCE;
    static TaskRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TaskRoomDb.class) {
                if (INSTANCE == null)    {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            TaskRoomDb.class, "todolist_database")
                            // .addCallback(sOnOpenCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }}}
        return INSTANCE;
    }
}
