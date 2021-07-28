package com.example.todoy;

import android.os.AsyncTask;

public class InsertTask extends AsyncTask<Void, Void, Void>{
        TaskDao mtaskDao;
        Task mtask;
public InsertTask(TaskDao mtaskDao,Task word){
        this.mtask=word;
        this.mtaskDao=mtaskDao;
        }


    @Override
    protected Void doInBackground(Void... voids) {
        mtaskDao.insert(mtask);
        return null;
    }
}
