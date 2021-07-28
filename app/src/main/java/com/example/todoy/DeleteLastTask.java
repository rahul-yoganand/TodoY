package com.example.todoy;

import android.os.AsyncTask;

public class DeleteLastTask extends AsyncTask<Void,Void,Void> {
    TaskDao mtaskDao;
    Task mtask;
    public DeleteLastTask(TaskDao mtaskDao,Task word){
        this.mtask=word;
        this.mtaskDao=mtaskDao;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        mtaskDao.delete(mtask);
        return null;
    }
}
