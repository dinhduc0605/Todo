package com.ducnd.todo.ui;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ducnd.todo.R;
import com.ducnd.todo.model.Job;
import com.ducnd.todo.util.DateUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nguyendinhduc on 14/12/2017.
 */

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.ViewHolder> {
    private static final String TAG = "JobListAdapter";
    private List<Job> mJobs;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Job job = mJobs.get(position);
        Log.d(TAG, job.getContent());
        holder.mTvJobContent.setText(job.getContent());
        String jobTime = DateUtil.formatDate(job.getTime(), DateUtil.DATE_FORMAT_1);
        holder.mTvJobTime.setText(jobTime);
    }

    @Override
    public int getItemCount() {
        return mJobs == null ? 0 : mJobs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_job_content)
        TextView mTvJobContent;
        @BindView(R.id.tv_job_time)
        TextView mTvJobTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setJobs(List<Job> jobs) {
        mJobs = jobs;
        notifyDataSetChanged();
    }
}
