package com.ducnd.todo;

import android.arch.lifecycle.LiveData;

import com.ducnd.todo.db.AppDatabase;
import com.ducnd.todo.model.Job;

import java.util.List;

/**
 * Created by nguyendinhduc on 07/12/2017.
 */

public class DataRepository {
    private AppDatabase mDatabase;
    private static DataRepository mInstance;
    private DataRepository(AppDatabase db){
        mDatabase = db;
    }

    public static DataRepository getDataRepository(AppDatabase db){
        if (mInstance == null){
            synchronized (DataRepository.class){
                mInstance = new DataRepository(db);
            }
        }
        return mInstance;
    }

    public void insertJob(Job job){
        mDatabase.mJobDao().insertJob(job);
    }

    public LiveData<List<Job>> getAllJobs(){
        return mDatabase.mJobDao().getAllJobs();
    }
}
