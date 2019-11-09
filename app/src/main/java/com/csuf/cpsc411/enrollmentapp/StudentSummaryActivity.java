package com.csuf.cpsc411.enrollmentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.csuf.cpsc411.enrollmentapp.Adapter.SummaryAdapter;
import com.csuf.cpsc411.enrollmentapp.Model.Student;
import com.csuf.cpsc411.enrollmentapp.Model.StudentEnrollments;

public class StudentSummaryActivity extends AppCompatActivity {

    protected ListView mSummaryView;
    protected SummaryAdapter ad;
    protected Menu summaryMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_summary);

        mSummaryView = findViewById(R.id.student_summary_id);
        ad = new SummaryAdapter();
        mSummaryView.setAdapter(ad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        summaryMenu = menu;
        getMenuInflater().inflate(R.menu.summary_menu_layout, summaryMenu);
        menu.findItem(R.id.action_add).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Student s = new Student("", "", 0);
        StudentEnrollments.getInstance().addStudent(s);

        Intent intent = new Intent(this, StudentDetailActivity.class);
        intent.putExtra("studentIndex", (S);
        startActivity(intent);


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        ad.notifyDataSetChanged();
        super.onStart();
    }
}
