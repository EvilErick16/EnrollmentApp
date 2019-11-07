package com.csuf.cpsc411.enrollmentapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.csuf.cpsc411.enrollmentapp.Adapter.SummaryAdapter;

public class StudentSummaryActivity extends Activity {

    protected ListView mSummaryView;
    protected SummaryAdapter ad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_summary);

        mSummaryView = findViewById(R.id.student_summary_id);
        ad = new SummaryAdapter();
        mSummaryView.setAdapter(ad);
    }

    @Override
    protected void onStart() {
        ad.notifyDataSetChanged();
        super.onStart();
    }
}
