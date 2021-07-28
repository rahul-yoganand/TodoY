package com.example.todoy;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insert(Task task);
    @Delete
    void delete(Task task);

    @Update
    public void updateWords(Task... tasks);

    @Query("DELETE FROM Task")
    void deleteAll();

    @Query("SELECT * from Task ORDER BY taskTitle ASC")
    List<Task> getAllWords();

    @Query("SELECT * FROM Task WHERE taskTitle LIKE :word ")
    public List<Task> findWord(String word);

    @Query("DELETE FROM Task WHERE uid=(SELECT MAX(uid) FROM Task)")
    void deleteLast();
}
