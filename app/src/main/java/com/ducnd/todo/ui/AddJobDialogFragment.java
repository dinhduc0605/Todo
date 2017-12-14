package com.ducnd.todo.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.ducnd.todo.R;
import com.ducnd.todo.model.Job;
import com.ducnd.todo.viewmodel.AddJobDialogViewModel;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nguyendinhduc on 07/12/2017.
 */

public class AddJobDialogFragment extends DialogFragment {

    public interface AddJobListener {
        void onDialogPositiveClick(DialogFragment dialog);

        void onDialogNegativeClick(DialogFragment dialog);
    }

    private Context mContext;
    private Date mTime;
    private AddJobDialogViewModel mAddJobDialogViewModel;

    @BindView(R.id.edt_job_content)
    EditText mEdtJobContent;

    @BindView(R.id.btn_set_time)
    Button mBtnSetTime;

    @BindView(R.id.btn_set_date)
    Button mBtnSetDate;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_date)
    TextView mTvDate;

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        View dialogView = LayoutInflater.from(mContext).inflate(R.layout.fragment_add_job_dialog, null);
        ButterKnife.bind(this, dialogView);
        mTime = new Date();
        mAddJobDialogViewModel = ViewModelProviders.of(this).get(AddJobDialogViewModel.class);
        bindWidgetControl();
        builder.setView(dialogView)
                .setPositiveButton("OK", (dialogInterface, i) -> {
                    Job job = new Job();
                    job.setContent(mEdtJobContent.getText().toString());
                    job.setTime(mTime);
                    Executors.newSingleThreadExecutor().execute(() -> {
                        mAddJobDialogViewModel.mDatabase.mJobDao().insertJob(job);
                    });
                    dialogInterface.cancel();
                })
                .setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.cancel());
        return builder.create();
    }

    private void bindWidgetControl() {
        mBtnSetTime.setOnClickListener(view -> {
            final Calendar calendar = Calendar.getInstance();
            Date currentDate = new Date();
            calendar.setTime(currentDate);
            new TimePickerDialog(mContext, (timePicker, hourOfDay, minute) -> {
                mTvTime.setText(String.format("%02d : %02d", hourOfDay, minute));
                mTime.setHours(hourOfDay);
                mTime.setMinutes(minute);
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
        });

        mBtnSetDate.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            Date currentDate = new Date();
            calendar.setTime(currentDate);
            new DatePickerDialog(mContext, (datePicker, year, month, dayOfMonth) -> {
                mTvDate.setText(String.format("%02d - %02d - %04d", month, dayOfMonth, year));
                mTime.setYear(year);
                mTime.setMonth(month);
                mTime.setDate(dayOfMonth);
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });
    }
}
