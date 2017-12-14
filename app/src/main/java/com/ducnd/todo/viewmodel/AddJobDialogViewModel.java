package com.ducnd.todo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.ducnd.todo.db.AppDatabase;

/**
 * Created by nguyendinhduc on 07/12/2017.
 */

public class AddJobDialogViewModel extends AndroidViewModel {
    public AppDatabase mDatabase;


    public AddJobDialogViewModel(Application application) {
        super(application);
        mDatabase = AppDatabase.getInstance(application);
    }

}
