package com.csuf.cpsc411.enrollmentapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.csuf.cpsc411.enrollmentapp.Model.Student;
import com.csuf.cpsc411.enrollmentapp.Model.StudentEnrollments;
import com.csuf.cpsc411.enrollmentapp.R;

public class SummaryAdapter extends BaseAdapter {



    @Override
    public int getCount() {
        return StudentEnrollments.getInstance().getStudents().size();
    }

    @Override
    public Object getItem(int i) {
        return StudentEnrollments.getInstance().getStudents().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);
        }
        else row_view = view;

        Student s = StudentEnrollments.getInstance().getStudents().get(i);

        TextView fNameView = row_view.findViewById(R.id.first_name);
        TextView lNameView = row_view.findViewById(R.id.last_name);

        fNameView.setText(s.getFirstName());
        lNameView.setText(s.getLastName());

        return row_view;
    }
}
