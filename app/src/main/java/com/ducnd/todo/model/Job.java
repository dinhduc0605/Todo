package com.ducnd.todo.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.ducnd.todo.db.DateConverter;

import java.util.Date;

/**
 * Created by nguyendinhduc on 06/12/2017.
 */

@Entity
public class Job {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int mId;

    private String mContent;

    @TypeConverters(DateConverter.class)
    private Date mTime;

    @NonNull
    public int getId() {
        return mId;
    }

    public void setId(@NonNull int id) {
        mId = id;
    }

    @NonNull
    public String getContent() {
        return mContent;
    }

    public void setContent(@NonNull String content) {
        mContent = content;
    }

    public Date getTime() {
        return mTime;
    }

    public void setTime(Date time) {
        mTime = time;
    }
}
