package com.example.todoy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

lateinit var recyclerView:RecyclerView
lateinit var fab: FloatingActionButton
private var layoutManager :RecyclerView.LayoutManager?=null

//lateinit var fab1: ExtendedFloatingActionButton
//lateinit var fab2: ExtendedFloatingActionButton
//var isFABOpen = false
class MainActivity : AppCompatActivity() {
    var data= listOf<Task>()
    lateinit var mtaskDao: TaskDao
    lateinit var roomDb: TaskRoomDb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.fab)
        recyclerView=findViewById(R.id.recycler)
        roomDb=TaskRoomDb.getDatabase(this)
        mtaskDao=roomDb.taskDao()
        layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerAdapter(data)
        recyclerView.adapter = adapter



        //fab1 = findViewById(R.id.fab1)
        //fab2 = findViewById(R.id.fab2)


    }
     override fun onStart() {
         super.onStart()
        var listData =FetchData(this,mtaskDao, recyclerView)
        listData.execute()
    }
    fun fabOnClick(view: View) {
        val intent= Intent(this,AddTask::class.java)
        startActivity(intent)
//        if (!isFABOpen) {
//            showFABMenu()
//        } else {
//            closeFABMenu()
//        }
    }


}