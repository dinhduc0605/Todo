package com.ducnd.todo.db;

/**
 * Created by nguyendinhduc on 07/12/2017.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.ducnd.todo.model.Job;

@Database(entities = {Job.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "todo-db";
    private static AppDatabase sDatabase;

    public abstract JobDao mJobDao();

    public static AppDatabase getInstance(Context context){
        if (sDatabase == null){
            synchronized (AppDatabase.class){
                sDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
            }
        }
        return sDatabase;
    }

    public static void destroyDatabse(){
        sDatabase = null;
    }
}
