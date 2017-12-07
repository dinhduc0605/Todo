package com.ducnd.todo.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import com.ducnd.todo.model.Job;

import java.util.List;

/**
 * Created by nguyendinhduc on 07/12/2017.
 */

@Dao
@TypeConverters(DateConverter.class)
public interface JobDao {

    @Query("SELECT * FROM Job")
    LiveData<List<Job>> getAllJobs();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertJob(Job job);

    @Update()
    void updateJob(Job job);

    @Delete()
    void deleteJob(Job job);

    @Query("DELETE FROM Job")
    void deleteAllJobs();
}
