package com.example.todoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

lateinit var task:EditText
lateinit var save: Button
lateinit var roomDb:TaskRoomDb
lateinit var taskDao: TaskDao
class AddTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        task=findViewById(R.id.etTask)
        save=findViewById(R.id.button)
        roomDb = TaskRoomDb.getDatabase(this)
        taskDao = roomDb.taskDao()

    }

    fun saveToDB(view: View) {
        var taskToAdd=task.text.toString()
        var word = Task(taskToAdd)
        var insertTask = InsertTask(taskDao,word)
        insertTask.execute()
    }
}