package com.csuf.cpsc411.enrollmentapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.csuf.cpsc411.enrollmentapp.Model.StudentEnrollments;
import com.csuf.cpsc411.enrollmentapp.Model.Vehicle;
import com.csuf.cpsc411.enrollmentapp.R;

public class VehicleAdapter extends BaseAdapter {

    private int studentIndex;
    private Boolean isEdit;

    public VehicleAdapter(int index, Boolean isEdit){
        this.studentIndex = index;
        this.isEdit = isEdit;
    }


    @Override
    public int getCount() {
        return StudentEnrollments.getInstance().getStudentCars(studentIndex).size();
    }

    @Override
    public Object getItem(int i) {
        return StudentEnrollments.getInstance().getStudentCars(studentIndex).get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View car_view;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            car_view = inflater.inflate(R.layout.vehicle_layout, viewGroup, false);
        }
        else car_view = view;

        Vehicle car = StudentEnrollments.getInstance().getStudents().get(studentIndex).getVehicles().get(i);

        TextView makeView = car_view.findViewById(R.id.make_id);
        TextView modelView = car_view.findViewById(R.id.model_id);
        TextView yearView = car_view.findViewById(R.id.year_id);

        makeView.setText(car.getMake());
        modelView.setText(car.getModel());
        String year = Integer.toString(car.getYear());
        yearView.setText(year);

        if (car.getYear() == 0){
            makeView.setEnabled(true);
            modelView.setEnabled(true);
            yearView.setEnabled(true);
        }
        else {
            makeView.setEnabled(false);
            modelView.setEnabled(false);
            yearView.setEnabled(false);
        }

        return car_view;
    }


}
