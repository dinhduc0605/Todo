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
public abstract class AppDatabse extends RoomDatabase {
    public static final String DATABASE_NAME = "todo-db";
    private static AppDatabse sDatabase;

    public abstract JobDao mJobDao();

    public static AppDatabse getInstance(Context context){
        if (sDatabase == null){
            sDatabase = Room.databaseBuilder(context, AppDatabse.class, DATABASE_NAME).build();
        }
        return sDatabase;
    }

    public static void destroyDatabse(){
        sDatabase = null;
    }
}
