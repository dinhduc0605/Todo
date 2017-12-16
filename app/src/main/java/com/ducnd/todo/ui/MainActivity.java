package com.ducnd.todo.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ducnd.todo.R;
import com.ducnd.todo.viewmodel.JobListViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.rc_list_todo)
    RecyclerView mRcListTodo;
    @BindView(R.id.fab_add_work)
    FloatingActionButton mFabAddWork;
    private JobListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        bindWidgetControl();
        JobListViewModel jobListViewModel = ViewModelProviders.of(this).get(JobListViewModel.class);
        subscribeUI(jobListViewModel);
    }

    private void initView() {
        mAdapter = new JobListAdapter();
        mRcListTodo.setAdapter(mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        mRcListTodo.addItemDecoration(dividerItemDecoration);
        mRcListTodo.setLayoutManager(linearLayoutManager);
    }

    private void bindWidgetControl() {
        mFabAddWork.setOnClickListener(view -> showAddWorkDialog());
    }

    private void showAddWorkDialog() {
        DialogFragment dialog = new AddJobDialogFragment();
        dialog.show(getSupportFragmentManager(), "AddJobDialogFragment");
    }

    private void subscribeUI(JobListViewModel jobListViewModel) {
        jobListViewModel.getJobList().observe(this, jobs -> {
            Log.d(TAG, "" + jobs.size());
            mAdapter.setJobs(jobs);
        });
    }
}
