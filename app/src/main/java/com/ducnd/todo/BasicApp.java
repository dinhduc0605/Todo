package com.ducnd.todo;

import android.app.Application;

import com.ducnd.todo.db.AppDatabase;

/**
 * Created by nguyendinhduc on 14/12/2017.
 */

public class BasicApp extends Application {
    public AppDatabase getDatabase(){
        return AppDatabase.getInstance(this);
    }

    public DataRepository getRepository(){
        return DataRepository.getDataRepository(getDatabase());
    }
}
