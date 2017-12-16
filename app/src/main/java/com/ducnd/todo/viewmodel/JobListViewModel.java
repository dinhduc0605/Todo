package com.ducnd.todo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.ducnd.todo.BasicApp;
import com.ducnd.todo.DataRepository;
import com.ducnd.todo.model.Job;

import java.util.List;

/**
 * Created by nguyendinhduc on 14/12/2017.
 */

public class JobListViewModel extends AndroidViewModel {
    private static DataRepository sDataRepository;
    public JobListViewModel(@NonNull Application application) {
        super(application);
        sDataRepository = ((BasicApp) application).getRepository();
    }

    public LiveData<List<Job>> getJobList(){
        return sDataRepository.getAllJobs();
    }
}
