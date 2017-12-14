package com.ducnd.todo.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ducnd.todo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rc_list_todo)
    RecyclerView mRcListTodo;
    @BindView(R.id.fab_add_work)
    FloatingActionButton mFabAddWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bindWidgetControl();
    }

    private void showAddWorkDialog() {
        DialogFragment dialog = new AddJobDialogFragment();
        dialog.show(getSupportFragmentManager(), "AddJobDialogFragment");
    }

    private void bindWidgetControl() {
        mFabAddWork.setOnClickListener(view -> showAddWorkDialog());
    }
}
