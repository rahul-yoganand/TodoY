package com.example.todoy;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.todoy.MainActivityKt.recyclerView;

public class FetchData extends AsyncTask<Void, Void, List<Task>> {
    List<Task> mListView;
    TaskDao mTaskDao;
    Context mContext;
    RecyclerView mrecyclerView;

    public FetchData(Context context, TaskDao taskDao, RecyclerView mrecyclerView) {
        mContext = context;
        this.mListView = mListView;
        this.mTaskDao = taskDao;
        this.mrecyclerView = mrecyclerView;

    }

    @Override
    protected List<Task> doInBackground(Void... voids) {
        mListView = mTaskDao.getAllWords();
        return mListView;
    }

    @Override
    protected void onPostExecute(List<Task> tasks) {
        super.onPostExecute(tasks);
        RecyclerAdapter adapter = new RecyclerAdapter(mListView);
        mrecyclerView.setAdapter(adapter);
    }
}
