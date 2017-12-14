package com.ducnd.todo;

import com.ducnd.todo.db.AppDatabase;

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
}
